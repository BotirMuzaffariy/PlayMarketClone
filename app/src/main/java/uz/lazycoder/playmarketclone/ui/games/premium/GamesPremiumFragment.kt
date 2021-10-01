package uz.lazycoder.playmarketclone.ui.games.premium

import android.os.Bundle
import android.view.View
import java.lang.Exception
import kotlinx.coroutines.*
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.lifecycle.MutableLiveData
import uz.lazycoder.playmarketclone.utils.Consts
import uz.lazycoder.playmarketclone.utils.showToast
import uz.lazycoder.playmarketclone.models.GameAndAppInnerSmallM
import uz.lazycoder.playmarketclone.adapters.RvGamesAndAppsKidsAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentGamesPremiumBinding

class GamesPremiumFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentGamesPremiumBinding
    private lateinit var gamesList: ArrayList<GameAndAppInnerSmallM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentGamesPremiumBinding.inflate(inflater, container, false)

        loadList()
        loadGameList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvGamesPremium.visibility = View.VISIBLE

                    rvGamesPremium.adapter = RvGamesAndAppsKidsAdapter(list, gamesList)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.games_premium_section_1),
            getString(R.string.games_premium_section_2),
            getString(R.string.games_premium_section_3),
            getString(R.string.games_premium_section_4),
            getString(R.string.games_premium_section_5),
            getString(R.string.games_premium_section_6)
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
                                "$0.85",
                                Consts.iconNormalUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "PUBG Mobile",
                                "$3.12",
                                Consts.iconNormalUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "Asphalt 9: Legends",
                                "$2.06",
                                Consts.iconNormalUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "Oddmar",
                                "$6.48",
                                Consts.iconNormalUrl
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e: Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.rvGamesPremium.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}