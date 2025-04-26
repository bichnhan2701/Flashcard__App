package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase;
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
public final class ProgressDetailViewModel_Factory implements Factory<ProgressDetailViewModel> {
  private final Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryProvider;

  public ProgressDetailViewModel_Factory(
      Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryProvider) {
    this.getFlashcardsByCategoryProvider = getFlashcardsByCategoryProvider;
  }

  @Override
  public ProgressDetailViewModel get() {
    return newInstance(getFlashcardsByCategoryProvider.get());
  }

  public static ProgressDetailViewModel_Factory create(
      Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryProvider) {
    return new ProgressDetailViewModel_Factory(getFlashcardsByCategoryProvider);
  }

  public static ProgressDetailViewModel newInstance(
      GetFlashcardsByCategoryUseCase getFlashcardsByCategory) {
    return new ProgressDetailViewModel(getFlashcardsByCategory);
  }
}
