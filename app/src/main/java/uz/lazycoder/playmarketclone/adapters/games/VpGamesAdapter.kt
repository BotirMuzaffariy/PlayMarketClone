package uz.lazycoder.playmarketclone.adapters.games

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.lazycoder.playmarketclone.ui.games.kids.GamesKidsFragment
import uz.lazycoder.playmarketclone.ui.games.foryou.GamesForYouFragment
import uz.lazycoder.playmarketclone.ui.games.premium.GamesPremiumFragment
import uz.lazycoder.playmarketclone.ui.games.topcharts.GamesTopChartsFragment
import uz.lazycoder.playmarketclone.ui.games.categories.GamesCategoriesFragment
import uz.lazycoder.playmarketclone.ui.games.editorschoice.GamesEditorsChoiceFragment

class VpGamesAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 6

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            // for you
            0 -> GamesForYouFragment()
            // top charts
            1 -> GamesTopChartsFragment()
            // kids
            2 -> GamesKidsFragment()
            // premium
            3 -> GamesPremiumFragment()
            // categories
            4 -> GamesCategoriesFragment()
            // editors' choice
            5 -> GamesEditorsChoiceFragment()
            // else
            else -> GamesForYouFragment()
        }
    }
}