package uz.lazycoder.playmarketclone.ui.games.kids

import android.os.Bundle
import android.view.View
import kotlinx.coroutines.*
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.lifecycle.MutableLiveData
import uz.lazycoder.playmarketclone.utils.showToast
import uz.lazycoder.playmarketclone.models.GameAndAppInnerSmallM
import uz.lazycoder.playmarketclone.adapters.RvGamesAndAppsKidsAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentGamesKidsBinding
import uz.lazycoder.playmarketclone.utils.Consts
import java.lang.Exception

class GamesKidsFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var binding: FragmentGamesKidsBinding
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var gamesList: ArrayList<GameAndAppInnerSmallM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentGamesKidsBinding.inflate(inflater, container, false)

        loadList()
        loadGameList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvGamesKids.visibility = View.VISIBLE

                    rvGamesKids.adapter = RvGamesAndAppsKidsAdapter(list, gamesList)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.games_kids_section_1),
            getString(R.string.games_kids_section_2),
            getString(R.string.games_kids_section_3),
            getString(R.string.games_kids_section_4),
            getString(R.string.games_kids_section_5),
            getString(R.string.games_kids_section_6)
        )
    }

    private fun loadGameList() {
        gamesList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..15) {
                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "Clash of Clans",
                                "303 MB",
                                Consts.iconNormalUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "PUBG Mobile",
                                "696 MB",
                                Consts.iconNormalUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "Asphalt 9: Legends",
                                "2.1 GB",
                                Consts.iconNormalUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "Oddmar",
                                "503 MB",
                                Consts.iconNormalUrl
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e: Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.rvGamesKids.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}