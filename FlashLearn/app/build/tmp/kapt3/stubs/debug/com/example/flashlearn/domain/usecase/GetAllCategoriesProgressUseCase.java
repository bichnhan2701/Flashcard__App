package com.example.flashlearn.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086B\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/flashlearn/domain/usecase/GetAllCategoriesProgressUseCase;", "", "categoryRepository", "Lcom/example/flashlearn/domain/repository/CategoryRepository;", "flashcardRepository", "Lcom/example/flashlearn/domain/repository/FlashcardRepository;", "(Lcom/example/flashlearn/domain/repository/CategoryRepository;Lcom/example/flashlearn/domain/repository/FlashcardRepository;)V", "invoke", "", "Lcom/example/flashlearn/domain/model/CategoryProgress;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetAllCategoriesProgressUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.repository.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository = null;
    
    @javax.inject.Inject()
    public GetAllCategoriesProgressUseCase(@org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.CategoryRepository categoryRepository, @org.jetbrains.annotations.NotNull()
    com.example.flashlearn.domain.repository.FlashcardRepository flashcardRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.flashlearn.domain.model.CategoryProgress>> $completion) {
        return null;
    }
}