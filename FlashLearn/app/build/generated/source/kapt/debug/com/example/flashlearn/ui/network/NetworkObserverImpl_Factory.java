package com.example.flashlearn.ui.network;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class NetworkObserverImpl_Factory implements Factory<NetworkObserverImpl> {
  private final Provider<Context> contextProvider;

  public NetworkObserverImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkObserverImpl get() {
    return newInstance(contextProvider.get());
  }

  public static NetworkObserverImpl_Factory create(Provider<Context> contextProvider) {
    return new NetworkObserverImpl_Factory(contextProvider);
  }

  public static NetworkObserverImpl newInstance(Context context) {
    return new NetworkObserverImpl(context);
  }
}
