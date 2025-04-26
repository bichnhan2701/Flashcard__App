package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.domain.repository.MiniQuizRepository;
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
public final class SaveMiniQuizResultUseCase_Factory implements Factory<SaveMiniQuizResultUseCase> {
  private final Provider<MiniQuizRepository> miniQuizRepositoryProvider;

  public SaveMiniQuizResultUseCase_Factory(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    this.miniQuizRepositoryProvider = miniQuizRepositoryProvider;
  }

  @Override
  public SaveMiniQuizResultUseCase get() {
    return newInstance(miniQuizRepositoryProvider.get());
  }

  public static SaveMiniQuizResultUseCase_Factory create(
      Provider<MiniQuizRepository> miniQuizRepositoryProvider) {
    return new SaveMiniQuizResultUseCase_Factory(miniQuizRepositoryProvider);
  }

  public static SaveMiniQuizResultUseCase newInstance(MiniQuizRepository miniQuizRepository) {
    return new SaveMiniQuizResultUseCase(miniQuizRepository);
  }
}
