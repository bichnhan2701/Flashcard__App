package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.domain.repository.FlashcardRepository;
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
public final class GetFlashcardsByCategoryUseCase_Factory implements Factory<GetFlashcardsByCategoryUseCase> {
  private final Provider<FlashcardRepository> repoProvider;

  public GetFlashcardsByCategoryUseCase_Factory(Provider<FlashcardRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetFlashcardsByCategoryUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetFlashcardsByCategoryUseCase_Factory create(
      Provider<FlashcardRepository> repoProvider) {
    return new GetFlashcardsByCategoryUseCase_Factory(repoProvider);
  }

  public static GetFlashcardsByCategoryUseCase newInstance(FlashcardRepository repo) {
    return new GetFlashcardsByCategoryUseCase(repo);
  }
}
