package com.example.flashlearn.ui.screen

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.flashlearn.R
import com.example.flashlearn.data.repository.PreferencesRepository
import com.example.flashlearn.navigation.Screen
import com.example.flashlearn.ui.component.ActionButton
import com.example.flashlearn.ui.component.BottomNavigationBar
import com.example.flashlearn.ui.viewmodel.AuthViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun UserProfileScreen(
    navController: NavController,
    preferences: PreferencesRepository,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    var isDarkMode by remember { mutableStateOf(false) }
    val authState by authViewModel.authState.collectAsState()
    val context = LocalContext.current

    val googleSignInClient = remember {
        GoogleSignIn.getClient(
            context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.server_client_id))
                .requestEmail()
                .build()
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        val account = task.result
        if (account != null) {
            val idToken = account.idToken
            if (idToken != null) {
                authViewModel.googleLogin(idToken)
            } else {
                Log.e("UserProfile", "Google Sign-In failed, idToken is null")
            }
        } else {
            Log.e("UserProfile", "Google Sign-In failed: ${task.exception?.message}")
        }
    }

    val user = FirebaseAuth.getInstance().currentUser

    LaunchedEffect(Unit) {
        isDarkMode = preferences.isDarkMode()
    }

    LaunchedEffect(authState) {
        authState?.let { result ->
            result
                .onSuccess {
                    navController.navigate(Screen.Profile.route) {
                        popUpTo(Screen.Profile.route) { inclusive = true }
                    }
                }
                .onFailure {
                    Log.e("Auth", "Đăng nhập thất bại: ${it.message}")
                }
        }
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF5F5F5))
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(Color(0xFFFFE6F0))
                        .padding(top = 32.dp, bottom = 72.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Text(
                        text = "My profile",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(56.dp))
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 160.dp)
                    .background(Color.White, shape = MaterialTheme.shapes.large)
                    .padding(top = 56.dp),
//                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = user?.displayName ?: "Guest User",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
                )

                SettingItem(
                    icon = painterResource(id = android.R.drawable.ic_menu_day),
                    title = "Dark mode",
                    trailing = {
                        Switch(
                            checked = isDarkMode,
                            onCheckedChange = {
                                isDarkMode = it
                                coroutineScope.launch {
                                    preferences.setDarkMode(it)
                                }
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.Blue,
                                uncheckedThumbColor = Color.Gray
                            )
                        )
                    }
                )

                SettingItem(
                    icon = painterResource(id = android.R.drawable.ic_menu_help),
                    title = "Help",
                    onClick = { navController.navigate("help") },
                    trailing = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Next",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )

                SettingItem(
                    icon = painterResource(id = android.R.drawable.ic_menu_info_details),
                    title = "About",
                    onClick = { navController.navigate("about") },
                    trailing = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "About",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                user?.let {
                    ActionButton(
                        text = "Logout",
                        onClick = {
                            authViewModel.logout(context)
                            navController.navigate(Screen.Profile.route) {
                                popUpTo(Screen.Profile.route) { inclusive = true }
                            }
                        },
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                } ?: run {
                    ActionButton(
                        text = "Login with Google",
                        onClick = { launcher.launch(googleSignInClient.signInIntent) },
                        containerColor = Color(0xFF4CAF50),
                        contentColor = Color.White
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 120.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                val avatarUrl = user?.photoUrl
                if (avatarUrl != null) {
                    AsyncImage(
                        model = avatarUrl,
                        contentDescription = "User Avatar",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.result_image),
                        contentDescription = "Default Avatar",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color.Gray)
                    )
                }
            }
        }
    }
}


@Composable
fun SettingItem(
    icon: androidx.compose.ui.graphics.painter.Painter,
    title: String,
    onClick: () -> Unit = {},
    trailing: @Composable () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFFEEC4F5)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.weight(1f))

        trailing()
    }
}

@Composable
fun AboutScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Text(
            text = "About Screen - Coming Soon",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        )
    }
}

@Composable
fun HelpScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Text(
            text = "Help Screen - Coming Soon",
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        )
    }
}