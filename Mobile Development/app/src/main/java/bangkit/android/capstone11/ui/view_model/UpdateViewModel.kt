package bangkit.android.capstone11.ui.view_model

import androidx.lifecycle.ViewModel
import bangkit.android.capstone11.data.repository.DataRepo

class UpdateViewModel(
    private val repository: DataRepo

) : ViewModel(){
    fun update(id: String, username: String, email: String) = repository.update(id,username, email)
}