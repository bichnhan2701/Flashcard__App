package com.example.flashlearn.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/example/flashlearn/domain/repository/SharedPreferencesRepository;", "", "getLastSyncedAt", "", "resetLastSyncedAt", "", "setLastSyncedAt", "timestamp", "app_debug"})
public abstract interface SharedPreferencesRepository {
    
    public abstract long getLastSyncedAt();
    
    public abstract void setLastSyncedAt(long timestamp);
    
    public abstract void resetLastSyncedAt();
}