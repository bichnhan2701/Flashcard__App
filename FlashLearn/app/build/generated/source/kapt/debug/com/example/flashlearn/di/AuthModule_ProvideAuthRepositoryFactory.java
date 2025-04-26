package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.AuthRepository;
import com.google.firebase.auth.FirebaseAuth;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AuthModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<FirebaseAuth> firebaseAuthProvider;

  public AuthModule_ProvideAuthRepositoryFactory(Provider<FirebaseAuth> firebaseAuthProvider) {
    this.firebaseAuthProvider = firebaseAuthProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(firebaseAuthProvider.get());
  }

  public static AuthModule_ProvideAuthRepositoryFactory create(
      Provider<FirebaseAuth> firebaseAuthProvider) {
    return new AuthModule_ProvideAuthRepositoryFactory(firebaseAuthProvider);
  }

  public static AuthRepository provideAuthRepository(FirebaseAuth firebaseAuth) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideAuthRepository(firebaseAuth));
  }
}
