package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase;
import com.example.flashlearn.domain.usecase.SyncAllDataUseCase;
import com.example.flashlearn.ui.network.NetworkObserver;
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

  private final Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider;

  private final Provider<NetworkObserver> networkObserverProvider;

  public HomeViewModel_Factory(Provider<GetAllCategoriesUseCase> getAllCategoriesUseCaseProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider,
      Provider<NetworkObserver> networkObserverProvider) {
    this.getAllCategoriesUseCaseProvider = getAllCategoriesUseCaseProvider;
    this.syncAllDataUseCaseProvider = syncAllDataUseCaseProvider;
    this.networkObserverProvider = networkObserverProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getAllCategoriesUseCaseProvider.get(), syncAllDataUseCaseProvider.get(), networkObserverProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<GetAllCategoriesUseCase> getAllCategoriesUseCaseProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider,
      Provider<NetworkObserver> networkObserverProvider) {
    return new HomeViewModel_Factory(getAllCategoriesUseCaseProvider, syncAllDataUseCaseProvider, networkObserverProvider);
  }

  public static HomeViewModel newInstance(GetAllCategoriesUseCase getAllCategoriesUseCase,
      SyncAllDataUseCase syncAllDataUseCase, NetworkObserver networkObserver) {
    return new HomeViewModel(getAllCategoriesUseCase, syncAllDataUseCase, networkObserver);
  }
}
