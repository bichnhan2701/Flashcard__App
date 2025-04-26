package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase;
import com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase;
import com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase;
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
public final class EditFolderDetailViewModel_Factory implements Factory<EditFolderDetailViewModel> {
  private final Provider<GetCategoryWithFlashcardsUseCase> getCategoryWithFlashcardsUseCaseProvider;

  private final Provider<UpdateCategoryWithFlashcardsUseCase> updateCategoryWithFlashcardsUseCaseProvider;

  private final Provider<DeleteCategoryWithFlashcardsUseCase> deleteCategoryWithFlashcardsUseCaseProvider;

  public EditFolderDetailViewModel_Factory(
      Provider<GetCategoryWithFlashcardsUseCase> getCategoryWithFlashcardsUseCaseProvider,
      Provider<UpdateCategoryWithFlashcardsUseCase> updateCategoryWithFlashcardsUseCaseProvider,
      Provider<DeleteCategoryWithFlashcardsUseCase> deleteCategoryWithFlashcardsUseCaseProvider) {
    this.getCategoryWithFlashcardsUseCaseProvider = getCategoryWithFlashcardsUseCaseProvider;
    this.updateCategoryWithFlashcardsUseCaseProvider = updateCategoryWithFlashcardsUseCaseProvider;
    this.deleteCategoryWithFlashcardsUseCaseProvider = deleteCategoryWithFlashcardsUseCaseProvider;
  }

  @Override
  public EditFolderDetailViewModel get() {
    return newInstance(getCategoryWithFlashcardsUseCaseProvider.get(), updateCategoryWithFlashcardsUseCaseProvider.get(), deleteCategoryWithFlashcardsUseCaseProvider.get());
  }

  public static EditFolderDetailViewModel_Factory create(
      Provider<GetCategoryWithFlashcardsUseCase> getCategoryWithFlashcardsUseCaseProvider,
      Provider<UpdateCategoryWithFlashcardsUseCase> updateCategoryWithFlashcardsUseCaseProvider,
      Provider<DeleteCategoryWithFlashcardsUseCase> deleteCategoryWithFlashcardsUseCaseProvider) {
    return new EditFolderDetailViewModel_Factory(getCategoryWithFlashcardsUseCaseProvider, updateCategoryWithFlashcardsUseCaseProvider, deleteCategoryWithFlashcardsUseCaseProvider);
  }

  public static EditFolderDetailViewModel newInstance(
      GetCategoryWithFlashcardsUseCase getCategoryWithFlashcardsUseCase,
      UpdateCategoryWithFlashcardsUseCase updateCategoryWithFlashcardsUseCase,
      DeleteCategoryWithFlashcardsUseCase deleteCategoryWithFlashcardsUseCase) {
    return new EditFolderDetailViewModel(getCategoryWithFlashcardsUseCase, updateCategoryWithFlashcardsUseCase, deleteCategoryWithFlashcardsUseCase);
  }
}
