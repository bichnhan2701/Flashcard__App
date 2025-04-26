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
public final class GetQuizHistoryByCategoryUseCase_Factory implements Factory<GetQuizHistoryByCategoryUseCase> {
  private final Provider<MiniQuizRepository> repoProvider;

  public GetQuizHistoryByCategoryUseCase_Factory(Provider<MiniQuizRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetQuizHistoryByCategoryUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetQuizHistoryByCategoryUseCase_Factory create(
      Provider<MiniQuizRepository> repoProvider) {
    return new GetQuizHistoryByCategoryUseCase_Factory(repoProvider);
  }

  public static GetQuizHistoryByCategoryUseCase newInstance(MiniQuizRepository repo) {
    return new GetQuizHistoryByCategoryUseCase(repo);
  }
}
