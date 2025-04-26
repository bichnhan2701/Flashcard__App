package com.example.flashlearn.data.repository;

import com.example.flashlearn.data.local.dao.CategoryDao;
import com.example.flashlearn.data.local.dao.FlashcardDao;
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
public final class CategoryRepositoryImpl_Factory implements Factory<CategoryRepositoryImpl> {
  private final Provider<CategoryDao> categoryDaoProvider;

  private final Provider<FlashcardDao> flashcardDaoProvider;

  public CategoryRepositoryImpl_Factory(Provider<CategoryDao> categoryDaoProvider,
      Provider<FlashcardDao> flashcardDaoProvider) {
    this.categoryDaoProvider = categoryDaoProvider;
    this.flashcardDaoProvider = flashcardDaoProvider;
  }

  @Override
  public CategoryRepositoryImpl get() {
    return newInstance(categoryDaoProvider.get(), flashcardDaoProvider.get());
  }

  public static CategoryRepositoryImpl_Factory create(Provider<CategoryDao> categoryDaoProvider,
      Provider<FlashcardDao> flashcardDaoProvider) {
    return new CategoryRepositoryImpl_Factory(categoryDaoProvider, flashcardDaoProvider);
  }

  public static CategoryRepositoryImpl newInstance(CategoryDao categoryDao,
      FlashcardDao flashcardDao) {
    return new CategoryRepositoryImpl(categoryDao, flashcardDao);
  }
}
