package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase;
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
public final class QuizHistoryViewModel_Factory implements Factory<QuizHistoryViewModel> {
  private final Provider<GetQuizHistoryByCategoryUseCase> getQuizHistoryProvider;

  private final Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider;

  private final Provider<NetworkObserver> networkObserverProvider;

  public QuizHistoryViewModel_Factory(
      Provider<GetQuizHistoryByCategoryUseCase> getQuizHistoryProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider,
      Provider<NetworkObserver> networkObserverProvider) {
    this.getQuizHistoryProvider = getQuizHistoryProvider;
    this.syncAllDataUseCaseProvider = syncAllDataUseCaseProvider;
    this.networkObserverProvider = networkObserverProvider;
  }

  @Override
  public QuizHistoryViewModel get() {
    return newInstance(getQuizHistoryProvider.get(), syncAllDataUseCaseProvider.get(), networkObserverProvider.get());
  }

  public static QuizHistoryViewModel_Factory create(
      Provider<GetQuizHistoryByCategoryUseCase> getQuizHistoryProvider,
      Provider<SyncAllDataUseCase> syncAllDataUseCaseProvider,
      Provider<NetworkObserver> networkObserverProvider) {
    return new QuizHistoryViewModel_Factory(getQuizHistoryProvider, syncAllDataUseCaseProvider, networkObserverProvider);
  }

  public static QuizHistoryViewModel newInstance(GetQuizHistoryByCategoryUseCase getQuizHistory,
      SyncAllDataUseCase syncAllDataUseCase, NetworkObserver networkObserver) {
    return new QuizHistoryViewModel(getQuizHistory, syncAllDataUseCase, networkObserver);
  }
}
