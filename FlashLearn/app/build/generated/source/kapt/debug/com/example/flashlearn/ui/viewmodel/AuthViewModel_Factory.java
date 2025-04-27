package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.LoginWithGoogleUseCase;
import com.example.flashlearn.domain.usecase.LogoutUseCase;
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase;
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

  private final Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider;

  public AuthViewModel_Factory(Provider<LoginWithGoogleUseCase> loginWithGoogleProvider,
      Provider<LogoutUseCase> logoutUseCaseProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider) {
    this.loginWithGoogleProvider = loginWithGoogleProvider;
    this.logoutUseCaseProvider = logoutUseCaseProvider;
    this.syncAllDataUseCaseProvider = syncAllDataUseCaseProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(loginWithGoogleProvider.get(), logoutUseCaseProvider.get(), syncAllDataUseCaseProvider.get());
  }

  public static AuthViewModel_Factory create(
      Provider<LoginWithGoogleUseCase> loginWithGoogleProvider,
      Provider<LogoutUseCase> logoutUseCaseProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider) {
    return new AuthViewModel_Factory(loginWithGoogleProvider, logoutUseCaseProvider, syncAllDataUseCaseProvider);
  }

  public static AuthViewModel newInstance(LoginWithGoogleUseCase loginWithGoogle,
      LogoutUseCase logoutUseCase, SyncAllDataUseCase syncAllDataUseCase) {
    return new AuthViewModel(loginWithGoogle, logoutUseCase, syncAllDataUseCase);
  }
}
