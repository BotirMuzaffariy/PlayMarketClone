package uz.lazycoder.playmarketclone.ui.games

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import uz.lazycoder.playmarketclone.MainActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import uz.lazycoder.playmarketclone.adapters.games.VpGamesAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentGamesBinding

class GamesFragment : Fragment() {

    private lateinit var tlList: List<String>
    private lateinit var binding: FragmentGamesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).showBottomNav()
        binding = FragmentGamesBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {
            vp2Games.isUserInputEnabled = false
            vp2Games.adapter = VpGamesAdapter(requireActivity())

            TabLayoutMediator(tlGames, vp2Games) { tab, position ->
                tab.text = tlList[position]
            }.attach()

            iSearch.cvMoreImg.setOnClickListener { findNavController().navigate(R.id.moreFunctionsFragment) }
        }

        return binding.root
    }

    private fun loadList() {
        tlList = listOf(
            getString(R.string.games_tab_text_1),
            getString(R.string.games_tab_text_2),
            getString(R.string.games_tab_text_3),
            getString(R.string.games_tab_text_4),
            getString(R.string.games_tab_text_5),
            getString(R.string.games_tab_text_6)
        )
    }

}