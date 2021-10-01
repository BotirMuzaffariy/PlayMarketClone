package uz.lazycoder.playmarketclone.utils

import android.content.Context
import android.content.SharedPreferences

class MySharedPrefs private constructor() {

    private val KEY_THEME = "theme"
    private val KEY_LANGUAGE = "language"

    companion object {
        private val PREF_NAME = "PLayStoreClonePrefs"

        private val mySharedPref = MySharedPrefs()
        private lateinit var editor: SharedPreferences.Editor
        private lateinit var sharedPreferences: SharedPreferences

        fun getInstance(context: Context): MySharedPrefs {
            if (!::sharedPreferences.isInitialized) {
                sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            }
            return mySharedPref
        }

    }

    fun setLanguage(language: String) {
        editor = sharedPreferences.edit()
        editor.putString(KEY_LANGUAGE, language)
        editor.commit()
    }

    fun getLanguage() = sharedPreferences.getString(KEY_LANGUAGE, Consts.LANG_EN) ?: Consts.LANG_EN

    fun setTheme(theme: String) {
        editor = sharedPreferences.edit()
        editor.putString(KEY_THEME, theme)
        editor.commit()
    }

    fun getTheme() = sharedPreferences.getString(KEY_THEME, Consts.THEME_SYSTEM)

}