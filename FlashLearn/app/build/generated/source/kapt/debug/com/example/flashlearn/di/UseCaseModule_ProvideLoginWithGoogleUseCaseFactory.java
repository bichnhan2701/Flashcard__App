package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.AuthRepository;
import com.example.flashlearn.domain.usecase.LoginWithGoogleUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class UseCaseModule_ProvideLoginWithGoogleUseCaseFactory implements Factory<LoginWithGoogleUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public UseCaseModule_ProvideLoginWithGoogleUseCaseFactory(
      Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LoginWithGoogleUseCase get() {
    return provideLoginWithGoogleUseCase(repositoryProvider.get());
  }

  public static UseCaseModule_ProvideLoginWithGoogleUseCaseFactory create(
      Provider<AuthRepository> repositoryProvider) {
    return new UseCaseModule_ProvideLoginWithGoogleUseCaseFactory(repositoryProvider);
  }

  public static LoginWithGoogleUseCase provideLoginWithGoogleUseCase(AuthRepository repository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideLoginWithGoogleUseCase(repository));
  }
}
