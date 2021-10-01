package uz.lazycoder.playmarketclone.adapters.apps

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.lazycoder.playmarketclone.ui.apps.kids.AppsKidsFragment
import uz.lazycoder.playmarketclone.ui.apps.foryou.AppsForYouFragment
import uz.lazycoder.playmarketclone.ui.apps.topcharts.AppsTopChartsFragment
import uz.lazycoder.playmarketclone.ui.apps.categories.AppsCategoriesFragment
import uz.lazycoder.playmarketclone.ui.apps.editorschoice.AppsEditorsChoiceFragment

class VpAppsAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            // for you
            0 -> AppsForYouFragment()
            // top charts
            1 -> AppsTopChartsFragment()
            // kids
            2 -> AppsKidsFragment()
            // categories
            3 -> AppsCategoriesFragment()
            // editors' choice
            4 -> AppsEditorsChoiceFragment()
            // else
            else -> AppsForYouFragment()
        }
    }
}