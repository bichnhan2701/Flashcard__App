package com.example.flashlearn.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/flashlearn/data/repository/PreferencesRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "hasSeenOnboarding", "", "isDarkMode", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDarkMode", "", "isDark", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSeenOnboarding", "app_debug"})
public final class PreferencesRepository {
    private final android.content.SharedPreferences sharedPrefs = null;
    
    public PreferencesRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setSeenOnboarding() {
    }
    
    public final boolean hasSeenOnboarding() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isDarkMode(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setDarkMode(boolean isDark, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}