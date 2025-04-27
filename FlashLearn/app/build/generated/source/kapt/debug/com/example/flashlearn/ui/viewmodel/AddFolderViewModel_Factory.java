package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.CreateCategoryUseCase;
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase;
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

  private final Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider;

  public AddFolderViewModel_Factory(Provider<CreateCategoryUseCase> createCategoryUseCaseProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider) {
    this.createCategoryUseCaseProvider = createCategoryUseCaseProvider;
    this.syncAllDataUseCaseProvider = syncAllDataUseCaseProvider;
  }

  @Override
  public AddFolderViewModel get() {
    return newInstance(createCategoryUseCaseProvider.get(), syncAllDataUseCaseProvider.get());
  }

  public static AddFolderViewModel_Factory create(
      Provider<CreateCategoryUseCase> createCategoryUseCaseProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider) {
    return new AddFolderViewModel_Factory(createCategoryUseCaseProvider, syncAllDataUseCaseProvider);
  }

  public static AddFolderViewModel newInstance(CreateCategoryUseCase createCategoryUseCase,
      SyncAllDataUseCase syncAllDataUseCase) {
    return new AddFolderViewModel(createCategoryUseCase, syncAllDataUseCase);
  }
}
