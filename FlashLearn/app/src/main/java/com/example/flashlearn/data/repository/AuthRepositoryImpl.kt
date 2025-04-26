package com.example.flashlearn.data.repository

import android.content.Context
import com.example.flashlearn.R
import com.example.flashlearn.domain.model.User
import com.example.flashlearn.domain.repository.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override suspend fun loginWithGoogle(idToken: String): Result<User> = try {
        val credential = GoogleAuthProvider.getCredential(idToken, null)  // Lấy credential từ ID token
        val result = firebaseAuth.signInWithCredential(credential).await()  // Đăng nhập Firebase
        val user = result.user
        if (user != null) {
            // Nếu người dùng đăng nhập thành công, chuyển thành object domain User
            Result.success(user.toDomainUser())
        } else {
            // Nếu không có thông tin người dùng, trả về lỗi
            Result.failure(Exception("Không thể lấy thông tin người dùng"))
        }
    } catch (e: Exception) {
        // Trả về lỗi nếu có exception trong quá trình đăng nhập
        Result.failure(Exception("Đăng nhập Google thất bại: ${e.localizedMessage}"))
    }

    override fun getCurrentUser(): User? {
        val firebaseUser = firebaseAuth.currentUser
        return firebaseUser?.toDomainUser()
    }

    override fun logout(context: Context) {
        // Đăng xuất Firebase
        firebaseAuth.signOut()

        // Đăng xuất khỏi Google
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(context, gso)
        googleSignInClient.signOut()
    }

}

fun FirebaseUser.toDomainUser(): User {
    return User(
        id = uid,
        email = email ?: "", // Kiểm tra null và gán chuỗi rỗng nếu email null
        displayName = displayName ?: "", // Kiểm tra null và gán chuỗi rỗng nếu displayName null
        photoUrl = photoUrl?.toString() ?: "" // Kiểm tra null và gán chuỗi rỗng nếu photoUrl null
    )
}
