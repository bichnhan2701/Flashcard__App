package com.example.flashlearn.ui.viewmodel;

import android.app.Application;
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
public final class FlashcardReviewViewModel_Factory implements Factory<FlashcardReviewViewModel> {
  private final Provider<Application> applicationProvider;

  private final Provider<FlashcardUseCases> flashcardUseCasesProvider;

  private final Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider;

  public FlashcardReviewViewModel_Factory(Provider<Application> applicationProvider,
      Provider<FlashcardUseCases> flashcardUseCasesProvider,
      Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider) {
    this.applicationProvider = applicationProvider;
    this.flashcardUseCasesProvider = flashcardUseCasesProvider;
    this.getCategoryByIdUseCaseProvider = getCategoryByIdUseCaseProvider;
  }

  @Override
  public FlashcardReviewViewModel get() {
    return newInstance(applicationProvider.get(), flashcardUseCasesProvider.get(), getCategoryByIdUseCaseProvider.get());
  }

  public static FlashcardReviewViewModel_Factory create(Provider<Application> applicationProvider,
      Provider<FlashcardUseCases> flashcardUseCasesProvider,
      Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider) {
    return new FlashcardReviewViewModel_Factory(applicationProvider, flashcardUseCasesProvider, getCategoryByIdUseCaseProvider);
  }

  public static FlashcardReviewViewModel newInstance(Application application,
      FlashcardUseCases flashcardUseCases, GetCategoryByIdUseCase getCategoryByIdUseCase) {
    return new FlashcardReviewViewModel(application, flashcardUseCases, getCategoryByIdUseCase);
  }
}
