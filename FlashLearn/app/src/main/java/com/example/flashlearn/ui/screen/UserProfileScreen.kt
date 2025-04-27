package com.example.flashlearn.ui.screen

import android.net.Uri
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
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import com.example.flashlearn.ui.component.LogoutConfirmationDialog

@Composable
fun UserProfileScreen(
    navController: NavController,
    preferences: PreferencesRepository,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    var isDarkMode by remember { mutableStateOf(false) }
    var showLogoutDialog by remember { mutableStateOf(false) }
    val authState by authViewModel.authState.collectAsState()
    val context = LocalContext.current
    val user = FirebaseAuth.getInstance().currentUser

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
        task.result?.idToken?.let { idToken ->
            authViewModel.googleLogin(idToken)
        } ?: Log.e("UserProfile", "Google Sign-In failed: ${task.exception?.message}")
    }

    LaunchedEffect(Unit) {
        isDarkMode = preferences.isDarkMode()
    }

    LaunchedEffect(authState) {
        authState?.onSuccess {
            navController.navigate(Screen.Profile.route) {
                popUpTo(Screen.Profile.route) { inclusive = true }
            }
        }?.onFailure {
            Log.e("Auth", "Đăng nhập thất bại: ${it.message}")
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
            ProfileHeader()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 155.dp)
                    .background(Color.White, shape = MaterialTheme.shapes.large)
                    .padding(top = 56.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileName(user?.displayName ?: "Guest User")

                ProfileSettings(
                    isDarkMode = isDarkMode,
                    onDarkModeChange = {
                        isDarkMode = it
                        coroutineScope.launch { preferences.setDarkMode(it) }
                    },
                    onHelpClick = {  },
                    onAboutClick = {  }
                )

                Spacer(modifier = Modifier.height(16.dp))

                ActionButton(
                    text = if (user != null) "Logout" else "Login with Google",
                    onClick = {
                        if (user != null) {
                            showLogoutDialog = true
                        } else {
                            launcher.launch(googleSignInClient.signInIntent)
                        }
                    },
                    containerColor = if (user != null) Color.Red else Color(0xFF4CAF50),
                    contentColor = Color.White,
                    modifier = Modifier.fillMaxWidth(0.6f)
                )
            }

            ProfileAvatar(user?.photoUrl)

            if (showLogoutDialog) {
                LogoutConfirmationDialog(
                    onConfirm = {
                        showLogoutDialog = false
                        authViewModel.logout(context)
                        navController.navigate(Screen.Profile.route) {
                            popUpTo(Screen.Profile.route) { inclusive = true }
                        }
                    },
                    onDismiss = { showLogoutDialog = false }
                )
            }
        }
    }
}

@Composable
private fun ProfileHeader() {
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
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF313F42)
        )
    }
}

@Composable
private fun ProfileName(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 16.dp)
    ) {
        Text(
            text = name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF39544F)
        )
    }
}

@Composable
private fun ProfileSettings(
    isDarkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    onHelpClick: () -> Unit,
    onAboutClick: () -> Unit
) {
    Text(
        text = "Settings",
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color(0xFF313F42),
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp).fillMaxWidth(),
        textAlign = TextAlign.Start

    )
    SettingItem(
        icon = painterResource(id = R.drawable.dark_mode_night_moon_svgrepo_com),
        title = "Dark mode",
        trailing = {
            Switch(
                checked = isDarkMode,
                onCheckedChange = onDarkModeChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Blue,
                    uncheckedThumbColor = Color.Gray
                )
            )
        }
    )
    SettingItem(
        icon = painterResource(id = R.drawable.help_svgrepo_com),
        title = "Help",
        onClick = onHelpClick,
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
        icon = painterResource(id = R.drawable.about_svgrepo_com),
        title = "About",
        onClick = onAboutClick,
        trailing = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "About",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    )
}

@Composable
private fun ProfileAvatar(photoUrl: Uri?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 90.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .size(135.dp) // lớn hơn ảnh một chút để tạo khung viền
                .clip(CircleShape)
                .shadow(
                    elevation = 8.dp,
                    shape = CircleShape,
                    ambientColor = Color.Gray,
                    spotColor = Color.Gray
                ),
            contentAlignment = Alignment.Center
        ) {
            if (photoUrl != null) {
                AsyncImage(
                    model = photoUrl,
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Default Avatar",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
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
            tint = Color(0xFF9485AC)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color(0xFF313F42)
        )
        Spacer(modifier = Modifier.weight(1f))
        trailing()
    }
}