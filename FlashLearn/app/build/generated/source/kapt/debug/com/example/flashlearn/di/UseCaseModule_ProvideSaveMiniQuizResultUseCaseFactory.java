package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.MiniQuizRepository;
import com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase;
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
public final class UseCaseModule_ProvideSaveMiniQuizResultUseCaseFactory implements Factory<SaveMiniQuizResultUseCase> {
  private final Provider<MiniQuizRepository> miniQuizRepositoryProvider;

  public UseCaseModule_ProvideSaveMiniQuizResultUseCaseFactory(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    this.miniQuizRepositoryProvider = miniQuizRepositoryProvider;
  }

  @Override
  public SaveMiniQuizResultUseCase get() {
    return provideSaveMiniQuizResultUseCase(miniQuizRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideSaveMiniQuizResultUseCaseFactory create(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    return new UseCaseModule_ProvideSaveMiniQuizResultUseCaseFactory(miniQuizRepositoryProvider);
  }

  public static SaveMiniQuizResultUseCase provideSaveMiniQuizResultUseCase(
      MiniQuizRepository miniQuizRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideSaveMiniQuizResultUseCase(miniQuizRepository));
  }
}
