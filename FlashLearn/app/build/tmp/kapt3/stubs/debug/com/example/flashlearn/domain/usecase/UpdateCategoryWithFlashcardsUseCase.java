package com.example.flashlearn.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086B\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/flashlearn/domain/usecase/UpdateCategoryWithFlashcardsUseCase;", "", "categoryRepository", "Lcom/example/flashlearn/domain/repository/CategoryRepository;", "flashcardRepository", "Lcom/example/flashlearn/domain/repository/FlashcardRepository;", "(Lcom/example/flashlearn/domain/repository/CategoryRepository;Lcom/example/flashlearn/domain/repository/FlashcardRepository;)V", "invoke", "", "categoryId", "", "newName", "", "updatedCards", "", "Lcom/example/flashlearn/domain/model/Flashcard;", "(ILjava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class UpdateCategoryWithFlashcardsUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.repository.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository = null;
    
    @javax.inject.Inject()
    public UpdateCategoryWithFlashcardsUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository categoryRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(int categoryId, @org.jetbrains.annotations.NotNull()
    java.lang.String newName, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.flashlearn.domain.model.Flashcard> updatedCards, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}