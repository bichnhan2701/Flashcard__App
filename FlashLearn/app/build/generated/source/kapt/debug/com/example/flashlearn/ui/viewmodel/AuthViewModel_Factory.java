package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.LoginWithGoogleUseCase;
import com.example.flashlearn.domain.usecase.LogoutUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<LoginWithGoogleUseCase> loginWithGoogleProvider;

  private final Provider<LogoutUseCase> logoutUseCaseProvider;

  public AuthViewModel_Factory(Provider<LoginWithGoogleUseCase> loginWithGoogleProvider,
      Provider<LogoutUseCase> logoutUseCaseProvider) {
    this.loginWithGoogleProvider = loginWithGoogleProvider;
    this.logoutUseCaseProvider = logoutUseCaseProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(loginWithGoogleProvider.get(), logoutUseCaseProvider.get());
  }

  public static AuthViewModel_Factory create(
      Provider<LoginWithGoogleUseCase> loginWithGoogleProvider,
      Provider<LogoutUseCase> logoutUseCaseProvider) {
    return new AuthViewModel_Factory(loginWithGoogleProvider, logoutUseCaseProvider);
  }

  public static AuthViewModel newInstance(LoginWithGoogleUseCase loginWithGoogle,
      LogoutUseCase logoutUseCase) {
    return new AuthViewModel(loginWithGoogle, logoutUseCase);
  }
}
