package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase;
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
public final class ProgressDetailViewModel_Factory implements Factory<ProgressDetailViewModel> {
  private final Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryProvider;

  private final Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider;

  private final Provider<NetworkObserver> networkObserverProvider;

  public ProgressDetailViewModel_Factory(
      Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider,
      Provider<NetworkObserver> networkObserverProvider) {
    this.getFlashcardsByCategoryProvider = getFlashcardsByCategoryProvider;
    this.syncAllDataUseCaseProvider = syncAllDataUseCaseProvider;
    this.networkObserverProvider = networkObserverProvider;
  }

  @Override
  public ProgressDetailViewModel get() {
    return newInstance(getFlashcardsByCategoryProvider.get(), syncAllDataUseCaseProvider.get(), networkObserverProvider.get());
  }

  public static ProgressDetailViewModel_Factory create(
      Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider,
      Provider<NetworkObserver> networkObserverProvider) {
    return new ProgressDetailViewModel_Factory(getFlashcardsByCategoryProvider, syncAllDataUseCaseProvider, networkObserverProvider);
  }

  public static ProgressDetailViewModel newInstance(
      GetFlashcardsByCategoryUseCase getFlashcardsByCategory, SyncAllDataUseCase syncAllDataUseCase,
      NetworkObserver networkObserver) {
    return new ProgressDetailViewModel(getFlashcardsByCategory, syncAllDataUseCase, networkObserver);
  }
}
