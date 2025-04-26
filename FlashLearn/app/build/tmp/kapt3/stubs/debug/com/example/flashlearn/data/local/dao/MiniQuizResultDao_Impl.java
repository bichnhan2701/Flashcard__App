package com.example.flashlearn.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0096@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/flashlearn/data/local/dao/MiniQuizResultDao_Impl;", "Lcom/example/flashlearn/data/local/dao/MiniQuizResultDao;", "__db", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "__converters", "Lcom/example/flashlearn/data/local/Converters;", "__insertAdapterOfMiniQuizResultEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/flashlearn/data/local/entity/MiniQuizResultEntity;", "getAllResults", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestResultByCategory", "categoryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResultsBetween", "start", "", "end", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResultsByCategory", "insert", "", "result", "(Lcom/example/flashlearn/data/local/entity/MiniQuizResultEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
@javax.annotation.processing.Generated(value = {"androidx.room.RoomProcessor"})
@kotlin.Suppress(names = {"UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"})
public final class MiniQuizResultDao_Impl implements com.example.flashlearn.data.local.dao.MiniQuizResultDao {
    @org.jetbrains.annotations.NotNull()
    private final androidx.room.RoomDatabase __db = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.room.EntityInsertAdapter<com.example.flashlearn.data.local.entity.MiniQuizResultEntity> __insertAdapterOfMiniQuizResultEntity = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.data.local.Converters __converters = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.flashlearn.data.local.dao.MiniQuizResultDao_Impl.Companion Companion = null;
    
    public MiniQuizResultDao_Impl(@org.jetbrains.annotations.NotNull()
    androidx.room.RoomDatabase __db) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.local.entity.MiniQuizResultEntity result, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getResultsByCategory(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.data.local.entity.MiniQuizResultEntity>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAllResults(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.data.local.entity.MiniQuizResultEntity>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getResultsBetween(long start, long end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.data.local.entity.MiniQuizResultEntity>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getLatestResultByCategory(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.flashlearn.data.local.entity.MiniQuizResultEntity> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/example/flashlearn/data/local/dao/MiniQuizResultDao_Impl$Companion;", "", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<kotlin.reflect.KClass<?>> getRequiredConverters() {
            return null;
        }
    }
}