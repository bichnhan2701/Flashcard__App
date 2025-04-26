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
public final class NotificationViewModel_Factory implements Factory<NotificationViewModel> {
  @Override
  public NotificationViewModel get() {
    return newInstance();
  }

  public static NotificationViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NotificationViewModel newInstance() {
    return new NotificationViewModel();
  }

  private static final class InstanceHolder {
    private static final NotificationViewModel_Factory INSTANCE = new NotificationViewModel_Factory();
  }
}
