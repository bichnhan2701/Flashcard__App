package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.AuthRepository;
import com.example.flashlearn.domain.usecase.LogoutUseCase;
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
public final class UseCaseModule_ProvideLogoutUseCaseFactory implements Factory<LogoutUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public UseCaseModule_ProvideLogoutUseCaseFactory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LogoutUseCase get() {
    return provideLogoutUseCase(repositoryProvider.get());
  }

  public static UseCaseModule_ProvideLogoutUseCaseFactory create(
      Provider<AuthRepository> repositoryProvider) {
    return new UseCaseModule_ProvideLogoutUseCaseFactory(repositoryProvider);
  }

  public static LogoutUseCase provideLogoutUseCase(AuthRepository repository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideLogoutUseCase(repository));
  }
}
