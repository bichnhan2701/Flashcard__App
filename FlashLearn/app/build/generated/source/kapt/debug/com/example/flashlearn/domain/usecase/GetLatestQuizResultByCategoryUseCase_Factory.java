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
public final class GetLatestQuizResultByCategoryUseCase_Factory implements Factory<GetLatestQuizResultByCategoryUseCase> {
  private final Provider<MiniQuizRepository> repositoryProvider;

  public GetLatestQuizResultByCategoryUseCase_Factory(
      Provider<MiniQuizRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetLatestQuizResultByCategoryUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetLatestQuizResultByCategoryUseCase_Factory create(
      Provider<MiniQuizRepository> repositoryProvider) {
    return new GetLatestQuizResultByCategoryUseCase_Factory(repositoryProvider);
  }

  public static GetLatestQuizResultByCategoryUseCase newInstance(MiniQuizRepository repository) {
    return new GetLatestQuizResultByCategoryUseCase(repository);
  }
}
