package com.example.flashlearn.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u00a6@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/example/flashlearn/data/remote/FirebaseRemoteDataSource;", "", "clearCurrentUserData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllData", "getAllData", "Lcom/example/flashlearn/domain/model/FirebaseDataBundle;", "uploadCategories", "categories", "", "Lcom/example/flashlearn/domain/model/Category;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFlashcards", "flashcards", "Lcom/example/flashlearn/domain/model/Flashcard;", "uploadMiniQuizResults", "results", "Lcom/example/flashlearn/domain/model/MiniQuizResult;", "app_debug"})
public abstract interface FirebaseRemoteDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadCategories(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.flashlearn.domain.model.Category> categories, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadFlashcards(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.flashlearn.domain.model.Flashcard> flashcards, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadMiniQuizResults(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.flashlearn.domain.model.MiniQuizResult> results, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.flashlearn.domain.model.FirebaseDataBundle> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearCurrentUserData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}