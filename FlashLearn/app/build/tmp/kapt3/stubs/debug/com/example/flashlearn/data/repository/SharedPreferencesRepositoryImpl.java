package com.example.flashlearn.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/flashlearn/data/repository/SharedPreferencesRepositoryImpl;", "Lcom/example/flashlearn/domain/repository/SharedPreferencesRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getLastSyncedAt", "", "resetLastSyncedAt", "", "setLastSyncedAt", "timestamp", "Companion", "app_debug"})
public final class SharedPreferencesRepositoryImpl implements com.example.flashlearn.domain.repository.SharedPreferencesRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LAST_SYNCED_AT = "key_last_synced_at";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.flashlearn.data.repository.SharedPreferencesRepositoryImpl.Companion Companion = null;
    
    @javax.inject.Inject()
    public SharedPreferencesRepositoryImpl(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences sharedPreferences) {
        super();
    }
    
    @java.lang.Override()
    public long getLastSyncedAt() {
        return 0L;
    }
    
    @java.lang.Override()
    public void setLastSyncedAt(long timestamp) {
    }
    
    @java.lang.Override()
    public void resetLastSyncedAt() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/flashlearn/data/repository/SharedPreferencesRepositoryImpl$Companion;", "", "()V", "KEY_LAST_SYNCED_AT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}