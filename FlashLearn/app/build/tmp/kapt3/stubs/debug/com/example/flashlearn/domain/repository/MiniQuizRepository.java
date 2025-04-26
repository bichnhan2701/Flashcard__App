package com.example.flashlearn.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/example/flashlearn/domain/repository/MiniQuizRepository;", "", "getAllQuizResults", "", "Lcom/example/flashlearn/domain/model/MiniQuizResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestResultByCategory", "categoryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuizResultsByCategory", "getResultsBetween", "start", "", "end", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveQuizResult", "", "result", "(Lcom/example/flashlearn/domain/model/MiniQuizResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MiniQuizRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveQuizResult(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.model.MiniQuizResult result, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getQuizResultsByCategory(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllQuizResults(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getResultsBetween(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLatestResultByCategory(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.flashlearn.domain.model.MiniQuizResult> $completion);
}