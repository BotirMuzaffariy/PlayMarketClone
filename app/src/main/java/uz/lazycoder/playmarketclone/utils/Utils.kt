package uz.lazycoder.playmarketclone.utils

import android.content.Context
import com.yariksoffice.lingver.Lingver
import androidx.appcompat.app.AppCompatDelegate

object Utils {

    fun changeTheme(context: Context, type: Int) {
        when (type) {
            // light
            0 -> {
                MySharedPrefs.getInstance(context).setTheme(Consts.THEME_LIGHT)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            // dark
            1 -> {
                MySharedPrefs.getInstance(context).setTheme(Consts.THEME_DARK)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            // system default
            2 -> {
                MySharedPrefs.getInstance(context).setTheme(Consts.THEME_SYSTEM)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }

    fun changeLanguage(context: Context, language: String) {
        Lingver.getInstance().setLocale(context, language)
        MySharedPrefs.getInstance(context).setLanguage(language)
    }

}