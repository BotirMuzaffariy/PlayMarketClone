package uz.lazycoder.playmarketclone.adapters.movies

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.lazycoder.playmarketclone.ui.movies.foryou.MoviesForYouFragment
import uz.lazycoder.playmarketclone.ui.movies.genres.MoviesGenresFragment
import uz.lazycoder.playmarketclone.ui.movies.studios.MoviesStudiosFragment
import uz.lazycoder.playmarketclone.ui.movies.topselling.MoviesTopSellingFragment
import uz.lazycoder.playmarketclone.ui.movies.newreleases.MoviesNewReleasesFragment

class VpMoviesAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            // for you
            0 -> MoviesForYouFragment()
            // top selling
            1 -> MoviesTopSellingFragment()
            // new releases
            2 -> MoviesNewReleasesFragment()
            // genres
            3 -> MoviesGenresFragment()
            // studios
            4 -> MoviesStudiosFragment()
            // else
            else -> MoviesForYouFragment()
        }
    }
}