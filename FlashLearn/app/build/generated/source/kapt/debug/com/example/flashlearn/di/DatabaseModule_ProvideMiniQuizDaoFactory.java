package com.example.flashlearn.di;

import com.example.flashlearn.data.local.AppDatabase;
import com.example.flashlearn.data.local.dao.MiniQuizResultDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DatabaseModule_ProvideMiniQuizDaoFactory implements Factory<MiniQuizResultDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideMiniQuizDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MiniQuizResultDao get() {
    return provideMiniQuizDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideMiniQuizDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideMiniQuizDaoFactory(databaseProvider);
  }

  public static MiniQuizResultDao provideMiniQuizDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideMiniQuizDao(database));
  }
}
