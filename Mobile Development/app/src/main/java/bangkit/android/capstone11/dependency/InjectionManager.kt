package bangkit.android.capstone11.dependency

import android.content.Context
import bangkit.android.capstone11.data.api_manager.ApiClient
import bangkit.android.capstone11.data.repository.DataRepo

object InjectionManager {
    fun provideRepository(context: Context): DataRepo {
        val apiService = ApiClient.getApiService()
        return DataRepo(apiService)
    }
}