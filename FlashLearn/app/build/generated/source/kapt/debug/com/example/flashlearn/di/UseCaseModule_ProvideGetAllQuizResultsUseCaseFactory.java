package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.MiniQuizRepository;
import com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase;
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
public final class UseCaseModule_ProvideGetAllQuizResultsUseCaseFactory implements Factory<GetAllQuizResultsUseCase> {
  private final Provider<MiniQuizRepository> miniQuizRepositoryProvider;

  public UseCaseModule_ProvideGetAllQuizResultsUseCaseFactory(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    this.miniQuizRepositoryProvider = miniQuizRepositoryProvider;
  }

  @Override
  public GetAllQuizResultsUseCase get() {
    return provideGetAllQuizResultsUseCase(miniQuizRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetAllQuizResultsUseCaseFactory create(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    return new UseCaseModule_ProvideGetAllQuizResultsUseCaseFactory(miniQuizRepositoryProvider);
  }

  public static GetAllQuizResultsUseCase provideGetAllQuizResultsUseCase(
      MiniQuizRepository miniQuizRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetAllQuizResultsUseCase(miniQuizRepository));
  }
}
