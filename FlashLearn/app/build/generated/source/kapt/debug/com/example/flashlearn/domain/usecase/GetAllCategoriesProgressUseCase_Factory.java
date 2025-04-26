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
public final class GetAllCategoriesProgressUseCase_Factory implements Factory<GetAllCategoriesProgressUseCase> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<FlashcardRepository> flashcardRepositoryProvider;

  public GetAllCategoriesProgressUseCase_Factory(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
    this.flashcardRepositoryProvider = flashcardRepositoryProvider;
  }

  @Override
  public GetAllCategoriesProgressUseCase get() {
    return newInstance(categoryRepositoryProvider.get(), flashcardRepositoryProvider.get());
  }

  public static GetAllCategoriesProgressUseCase_Factory create(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider) {
    return new GetAllCategoriesProgressUseCase_Factory(categoryRepositoryProvider, flashcardRepositoryProvider);
  }

  public static GetAllCategoriesProgressUseCase newInstance(CategoryRepository categoryRepository,
      FlashcardRepository flashcardRepository) {
    return new GetAllCategoriesProgressUseCase(categoryRepository, flashcardRepository);
  }
}
