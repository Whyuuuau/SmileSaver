package bangkit.android.capstone11.ui.view_model

import androidx.lifecycle.ViewModel
import bangkit.android.capstone11.data.repository.DataRepo

class SignUpViewModel(
    private val repository: DataRepo
) : ViewModel(){
    fun register(name: String, email: String, pass: String) = repository.register(name, email, pass)
}