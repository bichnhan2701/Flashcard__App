package com.example.flashlearn.di;

import com.example.flashlearn.domain.repository.CategoryRepository;
import com.example.flashlearn.domain.repository.FlashcardRepository;
import com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase;
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
public final class UseCaseModule_ProvideGetAllCategoriesProgressUseCaseFactory implements Factory<GetAllCategoriesProgressUseCase> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<FlashcardRepository> flashcardRepositoryProvider;

  public UseCaseModule_ProvideGetAllCategoriesProgressUseCaseFactory(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
    this.flashcardRepositoryProvider = flashcardRepositoryProvider;
  }

  @Override
  public GetAllCategoriesProgressUseCase get() {
    return provideGetAllCategoriesProgressUseCase(categoryRepositoryProvider.get(), flashcardRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetAllCategoriesProgressUseCaseFactory create(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<FlashcardRepository> flashcardRepositoryProvider) {
    return new UseCaseModule_ProvideGetAllCategoriesProgressUseCaseFactory(categoryRepositoryProvider, flashcardRepositoryProvider);
  }

  public static GetAllCategoriesProgressUseCase provideGetAllCategoriesProgressUseCase(
      CategoryRepository categoryRepository, FlashcardRepository flashcardRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetAllCategoriesProgressUseCase(categoryRepository, flashcardRepository));
  }
}
