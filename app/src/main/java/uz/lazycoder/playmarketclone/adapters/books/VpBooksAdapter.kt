package uz.lazycoder.playmarketclone.adapters.books

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.lazycoder.playmarketclone.ui.books.foryou.BooksForYouFragment
import uz.lazycoder.playmarketclone.ui.books.genres.BooksGenresFragment
import uz.lazycoder.playmarketclone.ui.books.topfree.BooksTopFreeFragment
import uz.lazycoder.playmarketclone.ui.books.topselling.BooksTopSellingFragment
import uz.lazycoder.playmarketclone.ui.books.newreleases.BooksNewReleasesFragment

class VpBooksAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            // for you
            0 -> BooksForYouFragment()
            // top selling
            1 -> BooksTopSellingFragment()
            // new releases
            2 -> BooksNewReleasesFragment()
            // genres
            3 -> BooksGenresFragment()
            // top free
            4 -> BooksTopFreeFragment()
            // else
            else -> BooksTopFreeFragment()
        }
    }

}