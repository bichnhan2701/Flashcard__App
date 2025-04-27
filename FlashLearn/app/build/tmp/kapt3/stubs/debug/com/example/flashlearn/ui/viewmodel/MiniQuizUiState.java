package com.example.flashlearn.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState;", "", "()V", "Finished", "Loaded", "Loading", "Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState$Finished;", "Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState$Loaded;", "Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState$Loading;", "app_debug"})
public abstract class MiniQuizUiState {
    
    private MiniQuizUiState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState$Finished;", "Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState;", "total", "", "correct", "(II)V", "getCorrect", "()I", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
    public static final class Finished extends com.example.flashlearn.ui.viewmodel.MiniQuizUiState {
        private final int total = 0;
        private final int correct = 0;
        
        public Finished(int total, int correct) {
        }
        
        public final int getTotal() {
            return 0;
        }
        
        public final int getCorrect() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.flashlearn.ui.viewmodel.MiniQuizUiState.Finished copy(int total, int correct) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003JN\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r\u00a8\u0006%"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState$Loaded;", "Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState;", "question", "Lcom/example/flashlearn/domain/model/MiniQuizQuestion;", "questionIndex", "", "totalQuestions", "selectedIndex", "isCorrect", "", "correctCount", "(Lcom/example/flashlearn/domain/model/MiniQuizQuestion;IILjava/lang/Integer;Ljava/lang/Boolean;I)V", "getCorrectCount", "()I", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getQuestion", "()Lcom/example/flashlearn/domain/model/MiniQuizQuestion;", "getQuestionIndex", "getSelectedIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalQuestions", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/example/flashlearn/domain/model/MiniQuizQuestion;IILjava/lang/Integer;Ljava/lang/Boolean;I)Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState$Loaded;", "equals", "other", "", "hashCode", "toString", "", "app_debug"})
    public static final class Loaded extends com.example.flashlearn.ui.viewmodel.MiniQuizUiState {
        @org.jetbrains.annotations.NotNull()
        private final com.example.flashlearn.domain.model.MiniQuizQuestion question = null;
        private final int questionIndex = 0;
        private final int totalQuestions = 0;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer selectedIndex = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Boolean isCorrect = null;
        private final int correctCount = 0;
        
        public Loaded(@org.jetbrains.annotations.NotNull()
        com.example.flashlearn.domain.model.MiniQuizQuestion question, int questionIndex, int totalQuestions, @org.jetbrains.annotations.Nullable()
        java.lang.Integer selectedIndex, @org.jetbrains.annotations.Nullable()
        java.lang.Boolean isCorrect, int correctCount) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.flashlearn.domain.model.MiniQuizQuestion getQuestion() {
            return null;
        }
        
        public final int getQuestionIndex() {
            return 0;
        }
        
        public final int getTotalQuestions() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getSelectedIndex() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Boolean isCorrect() {
            return null;
        }
        
        public final int getCorrectCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.flashlearn.domain.model.MiniQuizQuestion component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component4() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Boolean component5() {
            return null;
        }
        
        public final int component6() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.flashlearn.ui.viewmodel.MiniQuizUiState.Loaded copy(@org.jetbrains.annotations.NotNull()
        com.example.flashlearn.domain.model.MiniQuizQuestion question, int questionIndex, int totalQuestions, @org.jetbrains.annotations.Nullable()
        java.lang.Integer selectedIndex, @org.jetbrains.annotations.Nullable()
        java.lang.Boolean isCorrect, int correctCount) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState$Loading;", "Lcom/example/flashlearn/ui/viewmodel/MiniQuizUiState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Loading extends com.example.flashlearn.ui.viewmodel.MiniQuizUiState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.ui.viewmodel.MiniQuizUiState.Loading INSTANCE = null;
        
        private Loading() {
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}