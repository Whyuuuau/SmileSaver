package bangkit.android.capstone11.ui.view_model

import androidx.lifecycle.ViewModel
import bangkit.android.capstone11.data.repository.DataRepo

class LoginViewModel(
    private val repository: DataRepo

) : ViewModel(){
    fun login(email: String, pass: String) = repository.login(email, pass)
}