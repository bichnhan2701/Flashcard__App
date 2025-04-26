package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.CreateCategoryUseCase;
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
public final class AddFolderViewModel_Factory implements Factory<AddFolderViewModel> {
  private final Provider<CreateCategoryUseCase> createCategoryUseCaseProvider;

  public AddFolderViewModel_Factory(Provider<CreateCategoryUseCase> createCategoryUseCaseProvider) {
    this.createCategoryUseCaseProvider = createCategoryUseCaseProvider;
  }

  @Override
  public AddFolderViewModel get() {
    return newInstance(createCategoryUseCaseProvider.get());
  }

  public static AddFolderViewModel_Factory create(
      Provider<CreateCategoryUseCase> createCategoryUseCaseProvider) {
    return new AddFolderViewModel_Factory(createCategoryUseCaseProvider);
  }

  public static AddFolderViewModel newInstance(CreateCategoryUseCase createCategoryUseCase) {
    return new AddFolderViewModel(createCategoryUseCase);
  }
}
