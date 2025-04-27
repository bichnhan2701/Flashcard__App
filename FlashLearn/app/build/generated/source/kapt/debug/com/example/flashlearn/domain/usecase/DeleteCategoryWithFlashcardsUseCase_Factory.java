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
public final class DeleteCategoryWithFlashcardsUseCase_Factory implements Factory<DeleteCategoryWithFlashcardsUseCase> {
  private final Provider<FlashcardRepository> flashcardRepositoryProvider;

  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public DeleteCategoryWithFlashcardsUseCase_Factory(
      Provider<FlashcardRepository> flashcardRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    this.flashcardRepositoryProvider = flashcardRepositoryProvider;
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  @Override
  public DeleteCategoryWithFlashcardsUseCase get() {
    return newInstance(flashcardRepositoryProvider.get(), categoryRepositoryProvider.get());
  }

  public static DeleteCategoryWithFlashcardsUseCase_Factory create(
      Provider<FlashcardRepository> flashcardRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new DeleteCategoryWithFlashcardsUseCase_Factory(flashcardRepositoryProvider, categoryRepositoryProvider);
  }

  public static DeleteCategoryWithFlashcardsUseCase newInstance(
      FlashcardRepository flashcardRepository, CategoryRepository categoryRepository) {
    return new DeleteCategoryWithFlashcardsUseCase(flashcardRepository, categoryRepository);
  }
}
