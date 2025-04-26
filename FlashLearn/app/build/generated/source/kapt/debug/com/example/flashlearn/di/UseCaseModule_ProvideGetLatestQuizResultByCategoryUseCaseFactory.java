package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.MiniQuizRepository;
import com.example.flashlearn.domain.usecase.GetLatestQuizResultByCategoryUseCase;
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
public final class UseCaseModule_ProvideGetLatestQuizResultByCategoryUseCaseFactory implements Factory<GetLatestQuizResultByCategoryUseCase> {
  private final Provider<MiniQuizRepository> miniQuizRepositoryProvider;

  public UseCaseModule_ProvideGetLatestQuizResultByCategoryUseCaseFactory(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    this.miniQuizRepositoryProvider = miniQuizRepositoryProvider;
  }

  @Override
  public GetLatestQuizResultByCategoryUseCase get() {
    return provideGetLatestQuizResultByCategoryUseCase(miniQuizRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetLatestQuizResultByCategoryUseCaseFactory create(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    return new UseCaseModule_ProvideGetLatestQuizResultByCategoryUseCaseFactory(miniQuizRepositoryProvider);
  }

  public static GetLatestQuizResultByCategoryUseCase provideGetLatestQuizResultByCategoryUseCase(
      MiniQuizRepository miniQuizRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetLatestQuizResultByCategoryUseCase(miniQuizRepository));
  }
}
