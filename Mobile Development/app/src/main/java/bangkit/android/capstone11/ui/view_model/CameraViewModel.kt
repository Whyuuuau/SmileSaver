package bangkit.android.capstone11.ui.view_model

import androidx.lifecycle.ViewModel
import bangkit.android.capstone11.data.repository.DataRepo
import okhttp3.MultipartBody

class CameraViewModel(
    private val repository: DataRepo
) : ViewModel() {

    fun postImage(
        file: MultipartBody.Part
    ) = repository.postImage(file)
}