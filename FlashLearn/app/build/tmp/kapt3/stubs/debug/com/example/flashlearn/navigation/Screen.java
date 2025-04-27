package com.example.flashlearn.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\r\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\r\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f \u00a8\u0006!"}, d2 = {"Lcom/example/flashlearn/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Add", "Category", "EditFolderDetail", "FlashcardReview", "FolderDetail", "Home", "MiniQuiz", "MiniQuizResult", "Onboarding", "Profile", "Progress", "Splash", "StartMiniQuiz", "Lcom/example/flashlearn/navigation/Screen$Add;", "Lcom/example/flashlearn/navigation/Screen$Category;", "Lcom/example/flashlearn/navigation/Screen$EditFolderDetail;", "Lcom/example/flashlearn/navigation/Screen$FlashcardReview;", "Lcom/example/flashlearn/navigation/Screen$FolderDetail;", "Lcom/example/flashlearn/navigation/Screen$Home;", "Lcom/example/flashlearn/navigation/Screen$MiniQuiz;", "Lcom/example/flashlearn/navigation/Screen$MiniQuizResult;", "Lcom/example/flashlearn/navigation/Screen$Onboarding;", "Lcom/example/flashlearn/navigation/Screen$Profile;", "Lcom/example/flashlearn/navigation/Screen$Progress;", "Lcom/example/flashlearn/navigation/Screen$Splash;", "Lcom/example/flashlearn/navigation/Screen$StartMiniQuiz;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$Add;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "app_debug"})
    public static final class Add extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.Add INSTANCE = null;
        
        private Add() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$Category;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "app_debug"})
    public static final class Category extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.Category INSTANCE = null;
        
        private Category() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$EditFolderDetail;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "passCategoryId", "", "id", "", "app_debug"})
    public static final class EditFolderDetail extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.EditFolderDetail INSTANCE = null;
        
        private EditFolderDetail() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String passCategoryId(int id) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$FlashcardReview;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "passCategoryId", "", "categoryId", "", "app_debug"})
    public static final class FlashcardReview extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.FlashcardReview INSTANCE = null;
        
        private FlashcardReview() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String passCategoryId(int categoryId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$FolderDetail;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "passCategoryId", "", "categoryId", "", "app_debug"})
    public static final class FolderDetail extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.FolderDetail INSTANCE = null;
        
        private FolderDetail() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String passCategoryId(int categoryId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$Home;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$MiniQuiz;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "createRoute", "", "categoryId", "", "app_debug"})
    public static final class MiniQuiz extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.MiniQuiz INSTANCE = null;
        
        private MiniQuiz() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(int categoryId) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$MiniQuizResult;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "createRoute", "", "total", "", "correct", "app_debug"})
    public static final class MiniQuizResult extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.MiniQuizResult INSTANCE = null;
        
        private MiniQuizResult() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(int total, int correct) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$Onboarding;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "app_debug"})
    public static final class Onboarding extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.Onboarding INSTANCE = null;
        
        private Onboarding() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$Profile;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "app_debug"})
    public static final class Profile extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.Profile INSTANCE = null;
        
        private Profile() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$Progress;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "app_debug"})
    public static final class Progress extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.Progress INSTANCE = null;
        
        private Progress() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$Splash;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "app_debug"})
    public static final class Splash extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.Splash INSTANCE = null;
        
        private Splash() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/flashlearn/navigation/Screen$StartMiniQuiz;", "Lcom/example/flashlearn/navigation/Screen;", "()V", "createRoute", "", "categoryId", "", "app_debug"})
    public static final class StartMiniQuiz extends com.example.flashlearn.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.flashlearn.navigation.Screen.StartMiniQuiz INSTANCE = null;
        
        private StartMiniQuiz() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(int categoryId) {
            return null;
        }
    }
}