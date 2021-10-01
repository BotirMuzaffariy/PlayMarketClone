package uz.lazycoder.playmarketclone

import android.app.Application
import com.yariksoffice.lingver.Lingver
import uz.lazycoder.playmarketclone.utils.Utils
import uz.lazycoder.playmarketclone.utils.Consts
import uz.lazycoder.playmarketclone.utils.MySharedPrefs

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // change app language
        Lingver.init(this, MySharedPrefs.getInstance(this).getLanguage())

        // change app theme
        when (MySharedPrefs.getInstance(this).getTheme()) {
            Consts.THEME_LIGHT -> Utils.changeTheme(this, 0)
            Consts.THEME_DARK -> Utils.changeTheme(this, 1)
            Consts.THEME_SYSTEM -> Utils.changeTheme(this, 2)
            else -> Utils.changeTheme(this, 2)
        }
    }

}