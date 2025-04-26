package com.example.flashlearn.ui.viewmodel;

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
public final class FlashcardFormViewModel_Factory implements Factory<FlashcardFormViewModel> {
  @Override
  public FlashcardFormViewModel get() {
    return newInstance();
  }

  public static FlashcardFormViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FlashcardFormViewModel newInstance() {
    return new FlashcardFormViewModel();
  }

  private static final class InstanceHolder {
    private static final FlashcardFormViewModel_Factory INSTANCE = new FlashcardFormViewModel_Factory();
  }
}
