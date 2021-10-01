package uz.lazycoder.playmarketclone.utils

import kotlin.random.Random

object Consts {

    // for language
    const val LANG_UZ = "uz"
    const val LANG_RU = "ru"
    const val LANG_EN = "en"

    // for theme
    const val THEME_DARK = "dark"
    const val THEME_LIGHT = "light"
    const val THEME_SYSTEM = "system"

    // for icons images
    val iconSmallUrl = "https://picsum.photos/id/"
        get() {
            return field + "${Random.nextInt(500)}/150"
        }
    val iconNormalUrl = "https://picsum.photos/id/"
        get() {
            return field + "${Random.nextInt(500)}/250"
        }

    // others images
    val movieAndBookUrl = "https://picsum.photos/id/"
        get() {
            return field + "${Random.nextInt(500)}/200/400"
        }
    val screenshotUrl = "https://picsum.photos/id/"
        get() {
            return field + "${Random.nextInt(500)}/600/300"
        }

}