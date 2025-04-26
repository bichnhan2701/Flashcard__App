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
public final class DeleteFlashcardUseCase_Factory implements Factory<DeleteFlashcardUseCase> {
  private final Provider<FlashcardRepository> repoProvider;

  public DeleteFlashcardUseCase_Factory(Provider<FlashcardRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public DeleteFlashcardUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static DeleteFlashcardUseCase_Factory create(Provider<FlashcardRepository> repoProvider) {
    return new DeleteFlashcardUseCase_Factory(repoProvider);
  }

  public static DeleteFlashcardUseCase newInstance(FlashcardRepository repo) {
    return new DeleteFlashcardUseCase(repo);
  }
}
