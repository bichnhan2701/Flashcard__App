package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.repository.FlashcardRepository;
import com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase;
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
public final class UseCaseModule_ProvideGetFolderWithFlashcardsUseCaseFactory implements Factory<GetCategoryWithFlashcardsUseCase> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<FlashcardRepository> flashcardRepositoryProvider;

  public UseCaseModule_ProvideGetFolderWithFlashcardsUseCaseFactory(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
    this.flashcardRepositoryProvider = flashcardRepositoryProvider;
  }

  @Override
  public GetCategoryWithFlashcardsUseCase get() {
    return provideGetFolderWithFlashcardsUseCase(categoryRepositoryProvider.get(), flashcardRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetFolderWithFlashcardsUseCaseFactory create(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider) {
    return new UseCaseModule_ProvideGetFolderWithFlashcardsUseCaseFactory(categoryRepositoryProvider, flashcardRepositoryProvider);
  }

  public static GetCategoryWithFlashcardsUseCase provideGetFolderWithFlashcardsUseCase(
      CategoryRepository categoryRepository, FlashcardRepository flashcardRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetFolderWithFlashcardsUseCase(categoryRepository, flashcardRepository));
  }
}
