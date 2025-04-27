package com.example.flashlearn.di;

import android.content.Context;
import com.example.flashlearn.ui.network.NetworkObserver;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class NetworkModule_ProvideNetworkObserverFactory implements Factory<NetworkObserver> {
  private final Provider<Context> contextProvider;

  public NetworkModule_ProvideNetworkObserverFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkObserver get() {
    return provideNetworkObserver(contextProvider.get());
  }

  public static NetworkModule_ProvideNetworkObserverFactory create(
      Provider<Context> contextProvider) {
    return new NetworkModule_ProvideNetworkObserverFactory(contextProvider);
  }

  public static NetworkObserver provideNetworkObserver(Context context) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideNetworkObserver(context));
  }
}
