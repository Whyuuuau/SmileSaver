package bangkit.android.capstone11.ui.preferences

import android.content.Context

class UserManager(context: Context) {
    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setToken(token: String) {
        preferences.edit().putString(TOKEN, token).apply()
    }

    fun getToken(): String? {
        return preferences.getString(TOKEN, null)
    }

    fun setUsername(username: String) {
        preferences.edit().putString(USERNAME, username).apply()
    }

    fun getUsername(): String {
        val username= preferences.getString(USERNAME, null).toString()
        return username
    }

    fun setEmail(email: String) {
        preferences.edit().putString(EMAIL, email).apply()
    }

    fun getEmail(): String{
        val email= preferences.getString(EMAIL,null).toString()
        return email
    }

    fun setID(id: String){
        preferences.edit().putString(ID, id).apply()
    }

    fun getID(): String{
        return preferences.getString(ID, null).toString()
    }


    companion object {
        private const val PREFS_NAME = "pref"
        private const val TOKEN = "token"
        private const val EMAIL = "email"
        private const val USERNAME = "username"
        private const val ID = "id"
    }
}