package com.example.flashlearn.domain.usecase;

import com.example.flashlearn.domain.repository.CategoryRepository;
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
public final class GetCategoryByIdUseCase_Factory implements Factory<GetCategoryByIdUseCase> {
  private final Provider<CategoryRepository> repoProvider;

  public GetCategoryByIdUseCase_Factory(Provider<CategoryRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public GetCategoryByIdUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static GetCategoryByIdUseCase_Factory create(Provider<CategoryRepository> repoProvider) {
    return new GetCategoryByIdUseCase_Factory(repoProvider);
  }

  public static GetCategoryByIdUseCase newInstance(CategoryRepository repo) {
    return new GetCategoryByIdUseCase(repo);
  }
}
