package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.MiniQuizRepository;
import com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase;
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
public final class UseCaseModule_ProvideGetQuizHistoryByCategoryUseCaseFactory implements Factory<GetQuizHistoryByCategoryUseCase> {
  private final Provider<MiniQuizRepository> miniQuizRepositoryProvider;

  public UseCaseModule_ProvideGetQuizHistoryByCategoryUseCaseFactory(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    this.miniQuizRepositoryProvider = miniQuizRepositoryProvider;
  }

  @Override
  public GetQuizHistoryByCategoryUseCase get() {
    return provideGetQuizHistoryByCategoryUseCase(miniQuizRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetQuizHistoryByCategoryUseCaseFactory create(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    return new UseCaseModule_ProvideGetQuizHistoryByCategoryUseCaseFactory(miniQuizRepositoryProvider);
  }

  public static GetQuizHistoryByCategoryUseCase provideGetQuizHistoryByCategoryUseCase(
      MiniQuizRepository miniQuizRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetQuizHistoryByCategoryUseCase(miniQuizRepository));
  }
}
