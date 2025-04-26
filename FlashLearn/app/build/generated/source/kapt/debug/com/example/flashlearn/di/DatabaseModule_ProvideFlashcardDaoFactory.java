package com.example.flashlearn.di;

import com.example.flashlearn.data.local.AppDatabase;
import com.example.flashlearn.data.local.dao.FlashcardDao;
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
public final class DatabaseModule_ProvideFlashcardDaoFactory implements Factory<FlashcardDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideFlashcardDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public FlashcardDao get() {
    return provideFlashcardDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideFlashcardDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideFlashcardDaoFactory(databaseProvider);
  }

  public static FlashcardDao provideFlashcardDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideFlashcardDao(database));
  }
}
