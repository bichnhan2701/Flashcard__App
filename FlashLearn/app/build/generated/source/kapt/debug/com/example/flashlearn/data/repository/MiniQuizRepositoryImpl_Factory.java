package com.example.flashlearn.data.repository;

import com.example.flashlearn.data.local.dao.MiniQuizResultDao;
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
public final class MiniQuizRepositoryImpl_Factory implements Factory<MiniQuizRepositoryImpl> {
  private final Provider<MiniQuizResultDao> daoProvider;

  public MiniQuizRepositoryImpl_Factory(Provider<MiniQuizResultDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public MiniQuizRepositoryImpl get() {
    return newInstance(daoProvider.get());
  }

  public static MiniQuizRepositoryImpl_Factory create(Provider<MiniQuizResultDao> daoProvider) {
    return new MiniQuizRepositoryImpl_Factory(daoProvider);
  }

  public static MiniQuizRepositoryImpl newInstance(MiniQuizResultDao dao) {
    return new MiniQuizRepositoryImpl(dao);
  }
}
