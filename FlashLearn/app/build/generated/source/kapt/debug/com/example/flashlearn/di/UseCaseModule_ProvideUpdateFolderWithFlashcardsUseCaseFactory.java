package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.repository.FlashcardRepository;
import com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class UseCaseModule_ProvideUpdateFolderWithFlashcardsUseCaseFactory implements Factory<UpdateCategoryWithFlashcardsUseCase> {
  private final Provider<FlashcardRepository> flashcardRepositoryProvider;

  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public UseCaseModule_ProvideUpdateFolderWithFlashcardsUseCaseFactory(
      Provider<FlashcardRepository> flashcardRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    this.flashcardRepositoryProvider = flashcardRepositoryProvider;
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  @Override
  public UpdateCategoryWithFlashcardsUseCase get() {
    return provideUpdateFolderWithFlashcardsUseCase(flashcardRepositoryProvider.get(), categoryRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideUpdateFolderWithFlashcardsUseCaseFactory create(
      Provider<FlashcardRepository> flashcardRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new UseCaseModule_ProvideUpdateFolderWithFlashcardsUseCaseFactory(flashcardRepositoryProvider, categoryRepositoryProvider);
  }

  public static UpdateCategoryWithFlashcardsUseCase provideUpdateFolderWithFlashcardsUseCase(
      FlashcardRepository flashcardRepository, CategoryRepository categoryRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideUpdateFolderWithFlashcardsUseCase(flashcardRepository, categoryRepository));
  }
}
