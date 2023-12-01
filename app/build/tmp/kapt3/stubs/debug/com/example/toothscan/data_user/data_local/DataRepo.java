package com.example.toothscan.data_user.data_local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000e0\b2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fJB\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000e0\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fJ*\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u000e0\b2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/toothscan/data_user/data_local/DataRepo;", "", "storyDatabase", "Lcom/example/toothscan/data_user/data_local/DataStorage;", "apiService", "Lcom/example/toothscan/data_user/api_manager/ApiService;", "(Lcom/example/toothscan/data_user/data_local/DataStorage;Lcom/example/toothscan/data_user/api_manager/ApiService;)V", "getStories", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Lcom/example/toothscan/data_user/api_manager/api_response/ListStoryItem;", "token", "", "getWithLocation", "Lcom/example/toothscan/data_user/data_local/ResultResource;", "Lcom/example/toothscan/data_user/api_manager/api_response/StoryResponse;", "location", "", "login", "Lcom/example/toothscan/data_user/api_manager/api_response/LoginResponse;", "email", "pass", "postImage", "Lcom/example/toothscan/data_user/api_manager/api_response/UploadResult;", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "lat", "", "lon", "multiPort", "register", "Lcom/example/toothscan/data_user/api_manager/api_response/RegisterResult;", "name", "app_debug"})
public final class DataRepo {
    @org.jetbrains.annotations.NotNull
    private final com.example.toothscan.data_user.data_local.DataStorage storyDatabase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.toothscan.data_user.api_manager.ApiService apiService = null;
    
    public DataRepo(@org.jetbrains.annotations.NotNull
    com.example.toothscan.data_user.data_local.DataStorage storyDatabase, @org.jetbrains.annotations.NotNull
    com.example.toothscan.data_user.api_manager.ApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.toothscan.data_user.data_local.ResultResource<com.example.toothscan.data_user.api_manager.api_response.RegisterResult>> register(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String pass) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.toothscan.data_user.data_local.ResultResource<com.example.toothscan.data_user.api_manager.api_response.LoginResponse>> login(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String pass) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.example.toothscan.data_user.api_manager.api_response.ListStoryItem>> getStories(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.toothscan.data_user.data_local.ResultResource<com.example.toothscan.data_user.api_manager.api_response.UploadResult>> postImage(@org.jetbrains.annotations.NotNull
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody description, double lat, double lon, @org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    java.lang.String multiPort) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.example.toothscan.data_user.data_local.ResultResource<com.example.toothscan.data_user.api_manager.api_response.StoryResponse>> getWithLocation(int location, @org.jetbrains.annotations.NotNull
    java.lang.String token) {
        return null;
    }
}