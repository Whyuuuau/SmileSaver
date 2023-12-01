package com.example.toothscan.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/toothscan/model/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/toothscan/data_user/data_local/DataRepo;", "(Lcom/example/toothscan/data_user/data_local/DataRepo;)V", "getStory", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Lcom/example/toothscan/data_user/api_manager/api_response/ListStoryItem;", "token", "", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.toothscan.data_user.data_local.DataRepo repository = null;
    
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.example.toothscan.data_user.data_local.DataRepo repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.example.toothscan.data_user.api_manager.api_response.ListStoryItem>> getStory(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
        return null;
    }
}