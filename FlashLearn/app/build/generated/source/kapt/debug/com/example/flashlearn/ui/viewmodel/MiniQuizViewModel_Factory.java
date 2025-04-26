package com.example.flashlearn.ui.viewmodel;

import com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase;
import com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase;
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase;
import com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase;
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
public final class MiniQuizViewModel_Factory implements Factory<MiniQuizViewModel> {
  private final Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryUseCaseProvider;

  private final Provider<GenerateMiniQuizQuestionsUseCase> generateQuizQuestionsUseCaseProvider;

  private final Provider<SaveMiniQuizResultUseCase> saveMiniQuizResultUseCaseProvider;

  private final Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider;

  public MiniQuizViewModel_Factory(
      Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryUseCaseProvider,
      Provider<GenerateMiniQuizQuestionsUseCase> generateQuizQuestionsUseCaseProvider,
      Provider<SaveMiniQuizResultUseCase> saveMiniQuizResultUseCaseProvider,
      Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider) {
    this.getFlashcardsByCategoryUseCaseProvider = getFlashcardsByCategoryUseCaseProvider;
    this.generateQuizQuestionsUseCaseProvider = generateQuizQuestionsUseCaseProvider;
    this.saveMiniQuizResultUseCaseProvider = saveMiniQuizResultUseCaseProvider;
    this.getCategoryByIdUseCaseProvider = getCategoryByIdUseCaseProvider;
  }

  @Override
  public MiniQuizViewModel get() {
    return newInstance(getFlashcardsByCategoryUseCaseProvider.get(), generateQuizQuestionsUseCaseProvider.get(), saveMiniQuizResultUseCaseProvider.get(), getCategoryByIdUseCaseProvider.get());
  }

  public static MiniQuizViewModel_Factory create(
      Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryUseCaseProvider,
      Provider<GenerateMiniQuizQuestionsUseCase> generateQuizQuestionsUseCaseProvider,
      Provider<SaveMiniQuizResultUseCase> saveMiniQuizResultUseCaseProvider,
      Provider<GetCategoryByIdUseCase> getCategoryByIdUseCaseProvider) {
    return new MiniQuizViewModel_Factory(getFlashcardsByCategoryUseCaseProvider, generateQuizQuestionsUseCaseProvider, saveMiniQuizResultUseCaseProvider, getCategoryByIdUseCaseProvider);
  }

  public static MiniQuizViewModel newInstance(
      GetFlashcardsByCategoryUseCase getFlashcardsByCategoryUseCase,
      GenerateMiniQuizQuestionsUseCase generateQuizQuestionsUseCase,
      SaveMiniQuizResultUseCase saveMiniQuizResultUseCase,
      GetCategoryByIdUseCase getCategoryByIdUseCase) {
    return new MiniQuizViewModel(getFlashcardsByCategoryUseCase, generateQuizQuestionsUseCase, saveMiniQuizResultUseCase, getCategoryByIdUseCase);
  }
}
