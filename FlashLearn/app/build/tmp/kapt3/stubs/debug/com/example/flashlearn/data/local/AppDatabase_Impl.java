package com.example.flashlearn.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u001a\u0010\u0010\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u001aH\u0016J\"\u0010\u001b\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u000e0\u0011H\u0014J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/flashlearn/data/local/AppDatabase_Impl;", "Lcom/example/flashlearn/data/local/AppDatabase;", "()V", "_categoryDao", "Lkotlin/Lazy;", "Lcom/example/flashlearn/data/local/dao/CategoryDao;", "_flashcardDao", "Lcom/example/flashlearn/data/local/dao/FlashcardDao;", "_miniQuizResultDao", "Lcom/example/flashlearn/data/local/dao/MiniQuizResultDao;", "categoryDao", "clearAllTables", "", "createAutoMigrations", "", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "", "Lkotlin/reflect/KClass;", "Landroidx/room/migration/AutoMigrationSpec;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "flashcardDao", "getRequiredAutoMigrationSpecClasses", "", "getRequiredTypeConverterClasses", "miniQuizResultDao", "app_debug"})
@javax.annotation.processing.Generated(value = {"androidx.room.RoomProcessor"})
@kotlin.Suppress(names = {"UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"})
public final class AppDatabase_Impl extends com.example.flashlearn.data.local.AppDatabase {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<com.example.flashlearn.data.local.dao.CategoryDao> _categoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<com.example.flashlearn.data.local.dao.FlashcardDao> _flashcardDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy<com.example.flashlearn.data.local.dao.MiniQuizResultDao> _miniQuizResultDao = null;
    
    public AppDatabase_Impl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected androidx.room.RoomOpenDelegate createOpenDelegate() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected androidx.room.InvalidationTracker createInvalidationTracker() {
        return null;
    }
    
    @java.lang.Override()
    public void clearAllTables() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected java.util.Map<kotlin.reflect.KClass<?>, java.util.List<kotlin.reflect.KClass<?>>> getRequiredTypeConverterClasses() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.Set<kotlin.reflect.KClass<? extends androidx.room.migration.AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<androidx.room.migration.Migration> createAutoMigrations(@org.jetbrains.annotations.NotNull()
    java.util.Map<kotlin.reflect.KClass<? extends androidx.room.migration.AutoMigrationSpec>, ? extends androidx.room.migration.AutoMigrationSpec> autoMigrationSpecs) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.flashlearn.data.local.dao.CategoryDao categoryDao() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.flashlearn.data.local.dao.FlashcardDao flashcardDao() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.flashlearn.data.local.dao.MiniQuizResultDao miniQuizResultDao() {
        return null;
    }
}