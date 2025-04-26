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
public final class GetQuizResultsBetweenUseCase_Factory implements Factory<GetQuizResultsBetweenUseCase> {
  private final Provider<MiniQuizRepository> repositoryProvider;

  public GetQuizResultsBetweenUseCase_Factory(Provider<MiniQuizRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetQuizResultsBetweenUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetQuizResultsBetweenUseCase_Factory create(
      Provider<MiniQuizRepository> repositoryProvider) {
    return new GetQuizResultsBetweenUseCase_Factory(repositoryProvider);
  }

  public static GetQuizResultsBetweenUseCase newInstance(MiniQuizRepository repository) {
    return new GetQuizResultsBetweenUseCase(repository);
  }
}
