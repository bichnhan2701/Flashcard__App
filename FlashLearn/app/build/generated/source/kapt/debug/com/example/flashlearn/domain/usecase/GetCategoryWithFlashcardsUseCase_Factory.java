package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.domain.repository.CategoryRepository;
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
public final class GetCategoryWithFlashcardsUseCase_Factory implements Factory<GetCategoryWithFlashcardsUseCase> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<FlashcardRepository> flashcardRepositoryProvider;

  public GetCategoryWithFlashcardsUseCase_Factory(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
    this.flashcardRepositoryProvider = flashcardRepositoryProvider;
  }

  @Override
  public GetCategoryWithFlashcardsUseCase get() {
    return newInstance(categoryRepositoryProvider.get(), flashcardRepositoryProvider.get());
  }

  public static GetCategoryWithFlashcardsUseCase_Factory create(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider) {
    return new GetCategoryWithFlashcardsUseCase_Factory(categoryRepositoryProvider, flashcardRepositoryProvider);
  }

  public static GetCategoryWithFlashcardsUseCase newInstance(CategoryRepository categoryRepository,
      FlashcardRepository flashcardRepository) {
    return new GetCategoryWithFlashcardsUseCase(categoryRepository, flashcardRepository);
  }
}
