package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase;
import com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase;
import com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase;
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
public final class ProgressViewModel_Factory implements Factory<ProgressViewModel> {
  private final Provider<GetAllQuizResultsUseCase> getAllQuizResultsProvider;

  private final Provider<GetQuizResultsBetweenUseCase> getQuizResultsBetweenProvider;

  private final Provider<GetAllCategoriesProgressUseCase> getAllCategoriesProgressProvider;

  private final Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider;

  private final Provider<NetworkObserver> networkObserverProvider;

  public ProgressViewModel_Factory(Provider<GetAllQuizResultsUseCase> getAllQuizResultsProvider,
      Provider<GetQuizResultsBetweenUseCase> getQuizResultsBetweenProvider,
      Provider<GetAllCategoriesProgressUseCase> getAllCategoriesProgressProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider,
      Provider<NetworkObserver> networkObserverProvider) {
    this.getAllQuizResultsProvider = getAllQuizResultsProvider;
    this.getQuizResultsBetweenProvider = getQuizResultsBetweenProvider;
    this.getAllCategoriesProgressProvider = getAllCategoriesProgressProvider;
    this.syncAllDataUseCaseProvider = syncAllDataUseCaseProvider;
    this.networkObserverProvider = networkObserverProvider;
  }

  @Override
  public ProgressViewModel get() {
    return newInstance(getAllQuizResultsProvider.get(), getQuizResultsBetweenProvider.get(), getAllCategoriesProgressProvider.get(), syncAllDataUseCaseProvider.get(), networkObserverProvider.get());
  }

  public static ProgressViewModel_Factory create(
      Provider<GetAllQuizResultsUseCase> getAllQuizResultsProvider,
      Provider<GetQuizResultsBetweenUseCase> getQuizResultsBetweenProvider,
      Provider<GetAllCategoriesProgressUseCase> getAllCategoriesProgressProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider,
      Provider<NetworkObserver> networkObserverProvider) {
    return new ProgressViewModel_Factory(getAllQuizResultsProvider, getQuizResultsBetweenProvider, getAllCategoriesProgressProvider, syncAllDataUseCaseProvider, networkObserverProvider);
  }

  public static ProgressViewModel newInstance(GetAllQuizResultsUseCase getAllQuizResults,
      GetQuizResultsBetweenUseCase getQuizResultsBetween,
      GetAllCategoriesProgressUseCase getAllCategoriesProgress,
      SyncAllDataUseCase syncAllDataUseCase, NetworkObserver networkObserver) {
    return new ProgressViewModel(getAllQuizResults, getQuizResultsBetween, getAllCategoriesProgress, syncAllDataUseCase, networkObserver);
  }
}
