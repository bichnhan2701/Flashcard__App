package com.example.flashlearn.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u0016H\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/flashlearn/data/repository/CategoryRepositoryImpl;", "Lcom/example/flashlearn/domain/repository/CategoryRepository;", "categoryDao", "Lcom/example/flashlearn/data/local/dao/CategoryDao;", "flashcardDao", "Lcom/example/flashlearn/data/local/dao/FlashcardDao;", "(Lcom/example/flashlearn/data/local/dao/CategoryDao;Lcom/example/flashlearn/data/local/dao/FlashcardDao;)V", "addFlashcardsToCategory", "", "categoryId", "", "flashcards", "", "Lcom/example/flashlearn/domain/model/Flashcard;", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCategory", "category", "Lcom/example/flashlearn/domain/model/Category;", "(Lcom/example/flashlearn/domain/model/Category;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteById", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "Lkotlinx/coroutines/flow/Flow;", "getCategoryById", "updateName", "newName", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CategoryRepositoryImpl implements com.example.flashlearn.domain.repository.CategoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.data.local.dao.CategoryDao categoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.data.local.dao.FlashcardDao flashcardDao = null;
    
    @javax.inject.Inject()
    public CategoryRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.local.dao.CategoryDao categoryDao, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.data.local.dao.FlashcardDao flashcardDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object createCategory(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.model.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addFlashcardsToCategory(int categoryId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.flashlearn.domain.model.Flashcard> flashcards, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.flashlearn.domain.model.Category>> getAllCategories() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateName(int categoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String newName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteById(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCategoryById(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.flashlearn.domain.model.Category> $completion) {
        return null;
    }
}