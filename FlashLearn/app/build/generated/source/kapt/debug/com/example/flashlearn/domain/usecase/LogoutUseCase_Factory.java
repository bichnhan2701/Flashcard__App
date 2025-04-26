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
public final class LogoutUseCase_Factory implements Factory<LogoutUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public LogoutUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LogoutUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static LogoutUseCase_Factory create(Provider<AuthRepository> repositoryProvider) {
    return new LogoutUseCase_Factory(repositoryProvider);
  }

  public static LogoutUseCase newInstance(AuthRepository repository) {
    return new LogoutUseCase(repository);
  }
}
