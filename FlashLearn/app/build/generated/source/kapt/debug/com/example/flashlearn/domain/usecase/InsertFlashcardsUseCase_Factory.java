package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.domain.repository.FlashcardRepository;
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
public final class InsertFlashcardsUseCase_Factory implements Factory<InsertFlashcardsUseCase> {
  private final Provider<FlashcardRepository> repositoryProvider;

  public InsertFlashcardsUseCase_Factory(Provider<FlashcardRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public InsertFlashcardsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static InsertFlashcardsUseCase_Factory create(
      Provider<FlashcardRepository> repositoryProvider) {
    return new InsertFlashcardsUseCase_Factory(repositoryProvider);
  }

  public static InsertFlashcardsUseCase newInstance(FlashcardRepository repository) {
    return new InsertFlashcardsUseCase(repository);
  }
}
