package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase;
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

  public QuizHistoryViewModel_Factory(
      Provider<GetQuizHistoryByCategoryUseCase> getQuizHistoryProvider) {
    this.getQuizHistoryProvider = getQuizHistoryProvider;
  }

  @Override
  public QuizHistoryViewModel get() {
    return newInstance(getQuizHistoryProvider.get());
  }

  public static QuizHistoryViewModel_Factory create(
      Provider<GetQuizHistoryByCategoryUseCase> getQuizHistoryProvider) {
    return new QuizHistoryViewModel_Factory(getQuizHistoryProvider);
  }

  public static QuizHistoryViewModel newInstance(GetQuizHistoryByCategoryUseCase getQuizHistory) {
    return new QuizHistoryViewModel(getQuizHistory);
  }
}
