package com.example.flashlearn.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class GenerateMiniQuizQuestionsUseCase_Factory implements Factory<GenerateMiniQuizQuestionsUseCase> {
  @Override
  public GenerateMiniQuizQuestionsUseCase get() {
    return newInstance();
  }

  public static GenerateMiniQuizQuestionsUseCase_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GenerateMiniQuizQuestionsUseCase newInstance() {
    return new GenerateMiniQuizQuestionsUseCase();
  }

  private static final class InstanceHolder {
    private static final GenerateMiniQuizQuestionsUseCase_Factory INSTANCE = new GenerateMiniQuizQuestionsUseCase_Factory();
  }
}
