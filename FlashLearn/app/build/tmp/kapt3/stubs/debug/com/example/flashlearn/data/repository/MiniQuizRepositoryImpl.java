package com.example.flashlearn.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\fJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/flashlearn/data/repository/MiniQuizRepositoryImpl;", "Lcom/example/flashlearn/domain/repository/MiniQuizRepository;", "dao", "Lcom/example/flashlearn/data/local/dao/MiniQuizResultDao;", "(Lcom/example/flashlearn/data/local/dao/MiniQuizResultDao;)V", "getAllQuizResults", "", "Lcom/example/flashlearn/domain/model/MiniQuizResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestResultByCategory", "categoryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuizResultsByCategory", "getResultsBetween", "start", "", "end", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveQuizResult", "", "result", "(Lcom/example/flashlearn/domain/model/MiniQuizResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MiniQuizRepositoryImpl implements com.example.flashlearn.domain.repository.MiniQuizRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.data.local.dao.MiniQuizResultDao dao = null;
    
    @javax.inject.Inject()
    public MiniQuizRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.local.dao.MiniQuizResultDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveQuizResult(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.model.MiniQuizResult result, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getQuizResultsByCategory(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAllQuizResults(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getResultsBetween(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.domain.model.MiniQuizResult>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getLatestResultByCategory(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.flashlearn.domain.model.MiniQuizResult> $completion) {
        return null;
    }
}