package com.example.flashlearn.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000fH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/example/flashlearn/di/RepositoryModule;", "", "()V", "bindCategoryRepository", "Lcom/example/flashlearn/domain/repository/CategoryRepository;", "impl", "Lcom/example/flashlearn/data/repository/CategoryRepositoryImpl;", "bindFlashcardRepository", "Lcom/example/flashlearn/domain/repository/FlashcardRepository;", "Lcom/example/flashlearn/data/repository/FlashcardRepositoryImpl;", "bindMiniQuizRepository", "Lcom/example/flashlearn/domain/repository/MiniQuizRepository;", "Lcom/example/flashlearn/data/repository/MiniQuizRepositoryImpl;", "bindSharedPreferencesRepository", "Lcom/example/flashlearn/domain/repository/SharedPreferencesRepository;", "Lcom/example/flashlearn/data/repository/SharedPreferencesRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.flashlearn.domain.repository.CategoryRepository bindCategoryRepository(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.repository.CategoryRepositoryImpl impl);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.flashlearn.domain.repository.FlashcardRepository bindFlashcardRepository(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.repository.FlashcardRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.flashlearn.domain.repository.MiniQuizRepository bindMiniQuizRepository(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.repository.MiniQuizRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.flashlearn.domain.repository.SharedPreferencesRepository bindSharedPreferencesRepository(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.repository.SharedPreferencesRepositoryImpl impl);
}