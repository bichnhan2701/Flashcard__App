package com.example.flashlearn.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u000eH\u0082@\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/flashlearn/domain/usecase/SyncAllDataUseCase;", "", "categoryRepository", "Lcom/example/flashlearn/domain/repository/CategoryRepository;", "flashcardRepository", "Lcom/example/flashlearn/domain/repository/FlashcardRepository;", "miniQuizRepository", "Lcom/example/flashlearn/domain/repository/MiniQuizRepository;", "firebaseRemoteDataSource", "Lcom/example/flashlearn/data/remote/FirebaseRemoteDataSource;", "sharedPreferencesRepository", "Lcom/example/flashlearn/domain/repository/SharedPreferencesRepository;", "(Lcom/example/flashlearn/domain/repository/CategoryRepository;Lcom/example/flashlearn/domain/repository/FlashcardRepository;Lcom/example/flashlearn/domain/repository/MiniQuizRepository;Lcom/example/flashlearn/data/remote/FirebaseRemoteDataSource;Lcom/example/flashlearn/domain/repository/SharedPreferencesRepository;)V", "clearLocalDatabase", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAllData", "resetLastSyncedAt", "sync", "uploadNewData", "lastSyncedAt", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SyncAllDataUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.repository.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.repository.MiniQuizRepository miniQuizRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.data.remote.FirebaseRemoteDataSource firebaseRemoteDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.repository.SharedPreferencesRepository sharedPreferencesRepository = null;
    
    @javax.inject.Inject()
    public SyncAllDataUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository categoryRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.MiniQuizRepository miniQuizRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.remote.FirebaseRemoteDataSource firebaseRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.SharedPreferencesRepository sharedPreferencesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object uploadNewData(long lastSyncedAt, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object downloadAllData(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void resetLastSyncedAt() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearLocalDatabase(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}