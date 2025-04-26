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
public final class UpdateFlashcardUseCase_Factory implements Factory<UpdateFlashcardUseCase> {
  private final Provider<FlashcardRepository> repoProvider;

  public UpdateFlashcardUseCase_Factory(Provider<FlashcardRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public UpdateFlashcardUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static UpdateFlashcardUseCase_Factory create(Provider<FlashcardRepository> repoProvider) {
    return new UpdateFlashcardUseCase_Factory(repoProvider);
  }

  public static UpdateFlashcardUseCase newInstance(FlashcardRepository repo) {
    return new UpdateFlashcardUseCase(repo);
  }
}
