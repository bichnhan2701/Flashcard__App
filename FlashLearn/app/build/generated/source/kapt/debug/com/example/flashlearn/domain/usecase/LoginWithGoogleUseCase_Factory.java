package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.domain.repository.AuthRepository;
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
public final class LoginWithGoogleUseCase_Factory implements Factory<LoginWithGoogleUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public LoginWithGoogleUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LoginWithGoogleUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static LoginWithGoogleUseCase_Factory create(Provider<AuthRepository> repositoryProvider) {
    return new LoginWithGoogleUseCase_Factory(repositoryProvider);
  }

  public static LoginWithGoogleUseCase newInstance(AuthRepository repository) {
    return new LoginWithGoogleUseCase(repository);
  }
}
