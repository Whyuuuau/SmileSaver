package com.example.toothscan.preferences

import android.content.Context

object LanguageManager {
    private const val PREFERENCES_NAME = "LanguagePrefs"
    private const val KEY_SELECTED_LANGUAGE = "SelectedLanguage"

    fun setLanguage(context: Context, language: String?) {
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_SELECTED_LANGUAGE, language)
            .apply()
    }

    fun getLanguage(context: Context): String {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        return preferences.getString(KEY_SELECTED_LANGUAGE, "") ?: ""
    }
}
