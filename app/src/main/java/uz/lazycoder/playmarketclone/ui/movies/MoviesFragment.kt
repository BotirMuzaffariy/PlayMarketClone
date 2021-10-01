package uz.lazycoder.playmarketclone.ui.movies

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import uz.lazycoder.playmarketclone.MainActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import uz.lazycoder.playmarketclone.adapters.movies.VpMoviesAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private lateinit var tlList: List<String>
    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).showBottomNav()
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {
            vp2Movies.isUserInputEnabled = false
            iSearch.tvHint.text = getString(R.string.search_movies)

            vp2Movies.adapter = VpMoviesAdapter(requireActivity())

            TabLayoutMediator(tlMovies, vp2Movies) { tab, position ->
                tab.text = tlList[position]
            }.attach()

            iSearch.cvMoreImg.setOnClickListener { findNavController().navigate(R.id.moreFunctionsFragment) }
        }

        return binding.root
    }

    private fun loadList() {
        tlList = listOf(
            getString(R.string.movies_tab_text_1),
            getString(R.string.movies_tab_text_2),
            getString(R.string.movies_tab_text_3),
            getString(R.string.movies_tab_text_4),
            getString(R.string.movies_tab_text_5)
        )
    }

}