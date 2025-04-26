package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.MiniQuizRepository;
import com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase;
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
public final class UseCaseModule_ProvideGetQuizResultsBetweenUseCaseFactory implements Factory<GetQuizResultsBetweenUseCase> {
  private final Provider<MiniQuizRepository> miniQuizRepositoryProvider;

  public UseCaseModule_ProvideGetQuizResultsBetweenUseCaseFactory(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    this.miniQuizRepositoryProvider = miniQuizRepositoryProvider;
  }

  @Override
  public GetQuizResultsBetweenUseCase get() {
    return provideGetQuizResultsBetweenUseCase(miniQuizRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetQuizResultsBetweenUseCaseFactory create(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    return new UseCaseModule_ProvideGetQuizResultsBetweenUseCaseFactory(miniQuizRepositoryProvider);
  }

  public static GetQuizResultsBetweenUseCase provideGetQuizResultsBetweenUseCase(
      MiniQuizRepository miniQuizRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetQuizResultsBetweenUseCase(miniQuizRepository));
  }
}
