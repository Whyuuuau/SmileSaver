package com.example.toothscan.data_user.api_manager;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ%\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011JQ\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u00172\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u001b\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ/\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/example/toothscan/data_user/api_manager/ApiService;", "", "getStories", "Lcom/example/toothscan/data_user/api_manager/api_response/StoryResponse;", "page", "", "size", "token", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStoriesWithLocation", "loc", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/example/toothscan/data_user/api_manager/api_response/LoginResponse;", "email", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postImage", "Lcom/example/toothscan/data_user/api_manager/api_response/UploadResult;", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "lat", "", "lon", "type", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lcom/example/toothscan/data_user/api_manager/api_response/RegisterResult;", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.FormUrlEncoded
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object register(@retrofit2.http.Field(value = "name")
    @org.jetbrains.annotations.NotNull
    java.lang.String name, @retrofit2.http.Field(value = "email")
    @org.jetbrains.annotations.NotNull
    java.lang.String email, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.toothscan.data_user.api_manager.api_response.RegisterResult> $completion);
    
    @retrofit2.http.FormUrlEncoded
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@retrofit2.http.Field(value = "email")
    @org.jetbrains.annotations.NotNull
    java.lang.String email, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.toothscan.data_user.api_manager.api_response.LoginResponse> $completion);
    
    @retrofit2.http.GET(value = "stories")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStories(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.toothscan.data_user.api_manager.api_response.StoryResponse> $completion);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST(value = "stories")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object postImage(@retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    okhttp3.MultipartBody.Part file, @retrofit2.http.Part(value = "description")
    @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody description, @retrofit2.http.Part(value = "lat")
    @org.jetbrains.annotations.Nullable
    java.lang.Double lat, @retrofit2.http.Part(value = "lon")
    @org.jetbrains.annotations.Nullable
    java.lang.Double lon, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @retrofit2.http.Header(value = "Accept")
    @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.toothscan.data_user.api_manager.api_response.UploadResult> $completion);
    
    @retrofit2.http.GET(value = "stories")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStoriesWithLocation(@retrofit2.http.Query(value = "location")
    int loc, @retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.toothscan.data_user.api_manager.api_response.StoryResponse> $completion);
}