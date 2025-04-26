package com.example.flashlearn.di;

import com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class UseCaseModule_ProvideGenerateMiniQuizQuestionsUseCaseFactory implements Factory<GenerateMiniQuizQuestionsUseCase> {
  @Override
  public GenerateMiniQuizQuestionsUseCase get() {
    return provideGenerateMiniQuizQuestionsUseCase();
  }

  public static UseCaseModule_ProvideGenerateMiniQuizQuestionsUseCaseFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GenerateMiniQuizQuestionsUseCase provideGenerateMiniQuizQuestionsUseCase() {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGenerateMiniQuizQuestionsUseCase());
  }

  private static final class InstanceHolder {
    private static final UseCaseModule_ProvideGenerateMiniQuizQuestionsUseCaseFactory INSTANCE = new UseCaseModule_ProvideGenerateMiniQuizQuestionsUseCaseFactory();
  }
}
