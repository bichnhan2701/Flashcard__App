package com.example.flashlearn.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010&\u001a\u00020\'2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020,H\u0007J\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020,H\u0007J\u0010\u0010/\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u00101\u001a\u0002022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007\u00a8\u00063"}, d2 = {"Lcom/example/flashlearn/di/UseCaseModule;", "", "()V", "provideCreateCategoryUseCase", "Lcom/example/flashlearn/domain/usecase/CreateCategoryUseCase;", "repository", "Lcom/example/flashlearn/domain/repository/CategoryRepository;", "provideDeleteFolderWithFlashcardsUseCase", "Lcom/example/flashlearn/domain/usecase/DeleteCategoryWithFlashcardsUseCase;", "flashcardRepository", "Lcom/example/flashlearn/domain/repository/FlashcardRepository;", "categoryRepository", "provideFlashcardUseCases", "Lcom/example/flashlearn/domain/usecase/FlashcardUseCases;", "insertFlashcardsUseCase", "Lcom/example/flashlearn/domain/usecase/InsertFlashcardsUseCase;", "getFlashcardsByCategoryUseCase", "Lcom/example/flashlearn/domain/usecase/GetFlashcardsByCategoryUseCase;", "deleteFlashcardUseCase", "Lcom/example/flashlearn/domain/usecase/DeleteFlashcardUseCase;", "updateFlashcardUseCase", "Lcom/example/flashlearn/domain/usecase/UpdateFlashcardUseCase;", "provideGenerateMiniQuizQuestionsUseCase", "Lcom/example/flashlearn/domain/usecase/GenerateMiniQuizQuestionsUseCase;", "provideGetAllCategoriesProgressUseCase", "Lcom/example/flashlearn/domain/usecase/GetAllCategoriesProgressUseCase;", "provideGetAllCategoriesUseCase", "Lcom/example/flashlearn/domain/usecase/GetAllCategoriesUseCase;", "provideGetAllQuizResultsUseCase", "Lcom/example/flashlearn/domain/usecase/GetAllQuizResultsUseCase;", "miniQuizRepository", "Lcom/example/flashlearn/domain/repository/MiniQuizRepository;", "provideGetCategoryByIdUseCases", "Lcom/example/flashlearn/domain/usecase/GetCategoryByIdUseCase;", "provideGetFolderWithFlashcardsUseCase", "Lcom/example/flashlearn/domain/usecase/GetCategoryWithFlashcardsUseCase;", "provideGetLatestQuizResultByCategoryUseCase", "Lcom/example/flashlearn/domain/usecase/GetLatestQuizResultByCategoryUseCase;", "provideGetQuizHistoryByCategoryUseCase", "Lcom/example/flashlearn/domain/usecase/GetQuizHistoryByCategoryUseCase;", "provideGetQuizResultsBetweenUseCase", "Lcom/example/flashlearn/domain/usecase/GetQuizResultsBetweenUseCase;", "provideLoginWithGoogleUseCase", "Lcom/example/flashlearn/domain/usecase/LoginWithGoogleUseCase;", "Lcom/example/flashlearn/domain/repository/AuthRepository;", "provideLogoutUseCase", "Lcom/example/flashlearn/domain/usecase/LogoutUseCase;", "provideSaveMiniQuizResultUseCase", "Lcom/example/flashlearn/domain/usecase/SaveMiniQuizResultUseCase;", "provideUpdateFolderWithFlashcardsUseCase", "Lcom/example/flashlearn/domain/usecase/UpdateCategoryWithFlashcardsUseCase;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class UseCaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.flashlearn.di.UseCaseModule INSTANCE = null;
    
    private UseCaseModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.LoginWithGoogleUseCase provideLoginWithGoogleUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.AuthRepository repository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.LogoutUseCase provideLogoutUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.AuthRepository repository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GetAllCategoriesUseCase provideGetAllCategoriesUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository repository) {
        return null;
    }
    
    @dagger.Provides()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GetCategoryByIdUseCase provideGetCategoryByIdUseCases(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository repository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.CreateCategoryUseCase provideCreateCategoryUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository repository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.FlashcardUseCases provideFlashcardUseCases(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.InsertFlashcardsUseCase insertFlashcardsUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.GetFlashcardsByCategoryUseCase getFlashcardsByCategoryUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.DeleteFlashcardUseCase deleteFlashcardUseCase, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.usecase.UpdateFlashcardUseCase updateFlashcardUseCase) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GetCategoryWithFlashcardsUseCase provideGetFolderWithFlashcardsUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository categoryRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.UpdateCategoryWithFlashcardsUseCase provideUpdateFolderWithFlashcardsUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository categoryRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.DeleteCategoryWithFlashcardsUseCase provideDeleteFolderWithFlashcardsUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository categoryRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GenerateMiniQuizQuestionsUseCase provideGenerateMiniQuizQuestionsUseCase() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GetQuizHistoryByCategoryUseCase provideGetQuizHistoryByCategoryUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.MiniQuizRepository miniQuizRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.SaveMiniQuizResultUseCase provideSaveMiniQuizResultUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.MiniQuizRepository miniQuizRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GetAllQuizResultsUseCase provideGetAllQuizResultsUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.MiniQuizRepository miniQuizRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GetQuizResultsBetweenUseCase provideGetQuizResultsBetweenUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.MiniQuizRepository miniQuizRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GetLatestQuizResultByCategoryUseCase provideGetLatestQuizResultByCategoryUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.MiniQuizRepository miniQuizRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.flashlearn.domain.usecase.GetAllCategoriesProgressUseCase provideGetAllCategoriesProgressUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository categoryRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository) {
        return null;
    }
}