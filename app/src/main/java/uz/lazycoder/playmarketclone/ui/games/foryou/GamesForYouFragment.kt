package uz.lazycoder.playmarketclone.ui.games.foryou

import android.os.Bundle
import android.view.View
import kotlinx.coroutines.*
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.lifecycle.MutableLiveData
import uz.lazycoder.playmarketclone.utils.Consts
import uz.lazycoder.playmarketclone.models.TypeM
import uz.lazycoder.playmarketclone.utils.showToast
import uz.lazycoder.playmarketclone.models.GameAndAppM
import uz.lazycoder.playmarketclone.adapters.games.RvGamesForYouAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentGamesForYouBinding

class GamesForYouFragment : Fragment() {

    private lateinit var list: ArrayList<TypeM>
    private lateinit var gamesList: ArrayList<GameAndAppM>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentGamesForYouBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentGamesForYouBinding.inflate(inflater, container, false)

        loadList()
        loadGameList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvGamesForYou.visibility = View.VISIBLE

                    rvGamesForYou.adapter = RvGamesForYouAdapter(list, gamesList)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = ArrayList()
        list.add(TypeM(getString(R.string.games_for_you_section_1), "def"))
        list.add(TypeM(getString(R.string.games_for_you_section_2), ""))
        list.add(TypeM(getString(R.string.games_for_you_section_3), "def"))
        list.add(TypeM(getString(R.string.games_for_you_section_4), "def"))
        list.add(TypeM(getString(R.string.games_for_you_section_5), ""))
        list.add(TypeM(getString(R.string.games_for_you_section_6), "def"))
    }

    private fun loadGameList() {
        gamesList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..10) {
                        gamesList.add(
                            GameAndAppM(
                                "Clash of Clans",
                                getString(R.string.games_categories_15),
                                listOf("4X", getString(R.string.games_categories_1)),
                                Consts.iconSmallUrl,
                                "4.6",
                                "303 MB",
                                Consts.screenshotUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppM(
                                "PUBG Mobile",
                                getString(R.string.games_categories_1),
                                listOf(getString(R.string.games_categories_12)),
                                Consts.iconSmallUrl,
                                "4.3",
                                "696 MB",
                                Consts.screenshotUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppM(
                                "Asphalt 9: Legends",
                                getString(R.string.games_categories_11),
                                listOf(getString(R.string.games_categories_13), getString(R.string.games_categories_11)),
                                Consts.iconSmallUrl,
                                "4.5",
                                "2.1 GB",
                                Consts.screenshotUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppM(
                                "Oddmar",
                                getString(R.string.games_categories_2),
                                listOf(getString(R.string.games_categories_1), getString(R.string.games_categories_7)),
                                Consts.iconSmallUrl,
                                "4.6",
                                "503 MB",
                                Consts.screenshotUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppM(
                                "Hill Climb Racing",
                                getString(R.string.games_categories_11),
                                listOf(getString(R.string.games_categories_1)),
                                Consts.iconSmallUrl,
                                "4.2",
                                "58 MB",
                                Consts.screenshotUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppM(
                                "Super Mario Run",
                                getString(R.string.games_categories_1),
                                listOf(getString(R.string.games_categories_12)),
                                Consts.iconSmallUrl,
                                "3.8",
                                "83 MB",
                                Consts.screenshotUrl
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e:Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.rvGamesForYou.visibility = View.GONE
                showToast(e.message?:getString(R.string.tv_error))
            }
        }
    }

}