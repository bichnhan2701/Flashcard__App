package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetAllCategoriesUseCase> getAllCategoriesUseCaseProvider;

  public HomeViewModel_Factory(Provider<GetAllCategoriesUseCase> getAllCategoriesUseCaseProvider) {
    this.getAllCategoriesUseCaseProvider = getAllCategoriesUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getAllCategoriesUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<GetAllCategoriesUseCase> getAllCategoriesUseCaseProvider) {
    return new HomeViewModel_Factory(getAllCategoriesUseCaseProvider);
  }

  public static HomeViewModel newInstance(GetAllCategoriesUseCase getAllCategoriesUseCase) {
    return new HomeViewModel(getAllCategoriesUseCase);
  }
}
