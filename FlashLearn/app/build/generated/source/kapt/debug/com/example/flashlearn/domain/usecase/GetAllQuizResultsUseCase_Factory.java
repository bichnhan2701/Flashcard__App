package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.domain.repository.MiniQuizRepository;
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
public final class GetAllQuizResultsUseCase_Factory implements Factory<GetAllQuizResultsUseCase> {
  private final Provider<MiniQuizRepository> repositoryProvider;

  public GetAllQuizResultsUseCase_Factory(Provider<MiniQuizRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetAllQuizResultsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetAllQuizResultsUseCase_Factory create(
      Provider<MiniQuizRepository> repositoryProvider) {
    return new GetAllQuizResultsUseCase_Factory(repositoryProvider);
  }

  public static GetAllQuizResultsUseCase newInstance(MiniQuizRepository repository) {
    return new GetAllQuizResultsUseCase(repository);
  }
}
