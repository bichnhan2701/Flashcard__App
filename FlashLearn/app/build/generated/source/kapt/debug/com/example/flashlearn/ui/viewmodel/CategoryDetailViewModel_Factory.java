package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.FlashcardUseCases;
import com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase;
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
public final class CategoryDetailViewModel_Factory implements Factory<CategoryDetailViewModel> {
  private final Provider<FlashcardUseCases> flashcardUseCasesProvider;

  private final Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider;

  public CategoryDetailViewModel_Factory(Provider<FlashcardUseCases> flashcardUseCasesProvider,
      Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider) {
    this.flashcardUseCasesProvider = flashcardUseCasesProvider;
    this.getCategoryByIdUseCaseProvider = getCategoryByIdUseCaseProvider;
  }

  @Override
  public CategoryDetailViewModel get() {
    return newInstance(flashcardUseCasesProvider.get(), getCategoryByIdUseCaseProvider.get());
  }

  public static CategoryDetailViewModel_Factory create(
      Provider<FlashcardUseCases> flashcardUseCasesProvider,
      Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider) {
    return new CategoryDetailViewModel_Factory(flashcardUseCasesProvider, getCategoryByIdUseCaseProvider);
  }

  public static CategoryDetailViewModel newInstance(FlashcardUseCases flashcardUseCases,
      GetCategoryByIdUseCase getCategoryByIdUseCase) {
    return new CategoryDetailViewModel(flashcardUseCases, getCategoryByIdUseCase);
  }
}
