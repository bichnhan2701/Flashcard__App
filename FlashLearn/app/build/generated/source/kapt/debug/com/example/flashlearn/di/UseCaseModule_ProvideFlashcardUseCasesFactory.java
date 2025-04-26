package com.example.flashlearn.di;

import com.example.flashlearn.domain.usecase.DeleteFlashcardUseCase;
import com.example.flashlearn.domain.usecase.FlashcardUseCases;
import com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase;
import com.example.flashlearn.domain.usecase.InsertFlashcardsUseCase;
import com.example.flashlearn.domain.usecase.UpdateFlashcardUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class UseCaseModule_ProvideFlashcardUseCasesFactory implements Factory<FlashcardUseCases> {
  private final Provider<InsertFlashcardsUseCase> insertFlashcardsUseCaseProvider;

  private final Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryUseCaseProvider;

  private final Provider<DeleteFlashcardUseCase> deleteFlashcardUseCaseProvider;

  private final Provider<UpdateFlashcardUseCase> updateFlashcardUseCaseProvider;

  public UseCaseModule_ProvideFlashcardUseCasesFactory(
      Provider<InsertFlashcardsUseCase> insertFlashcardsUseCaseProvider,
      Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryUseCaseProvider,
      Provider<DeleteFlashcardUseCase> deleteFlashcardUseCaseProvider,
      Provider<UpdateFlashcardUseCase> updateFlashcardUseCaseProvider) {
    this.insertFlashcardsUseCaseProvider = insertFlashcardsUseCaseProvider;
    this.getFlashcardsByCategoryUseCaseProvider = getFlashcardsByCategoryUseCaseProvider;
    this.deleteFlashcardUseCaseProvider = deleteFlashcardUseCaseProvider;
    this.updateFlashcardUseCaseProvider = updateFlashcardUseCaseProvider;
  }

  @Override
  public FlashcardUseCases get() {
    return provideFlashcardUseCases(insertFlashcardsUseCaseProvider.get(), getFlashcardsByCategoryUseCaseProvider.get(), deleteFlashcardUseCaseProvider.get(), updateFlashcardUseCaseProvider.get());
  }

  public static UseCaseModule_ProvideFlashcardUseCasesFactory create(
      Provider<InsertFlashcardsUseCase> insertFlashcardsUseCaseProvider,
      Provider<GetFlashcardsByCategoryUseCase> getFlashcardsByCategoryUseCaseProvider,
      Provider<DeleteFlashcardUseCase> deleteFlashcardUseCaseProvider,
      Provider<UpdateFlashcardUseCase> updateFlashcardUseCaseProvider) {
    return new UseCaseModule_ProvideFlashcardUseCasesFactory(insertFlashcardsUseCaseProvider, getFlashcardsByCategoryUseCaseProvider, deleteFlashcardUseCaseProvider, updateFlashcardUseCaseProvider);
  }

  public static FlashcardUseCases provideFlashcardUseCases(
      InsertFlashcardsUseCase insertFlashcardsUseCase,
      GetFlashcardsByCategoryUseCase getFlashcardsByCategoryUseCase,
      DeleteFlashcardUseCase deleteFlashcardUseCase,
      UpdateFlashcardUseCase updateFlashcardUseCase) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideFlashcardUseCases(insertFlashcardsUseCase, getFlashcardsByCategoryUseCase, deleteFlashcardUseCase, updateFlashcardUseCase));
  }
}
