package uz.lazycoder.playmarketclone.ui.games.topcharts

import android.os.Bundle
import android.view.View
import kotlinx.coroutines.*
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.lifecycle.MutableLiveData
import uz.lazycoder.playmarketclone.utils.Consts
import uz.lazycoder.playmarketclone.utils.showToast
import uz.lazycoder.playmarketclone.models.GameAndAppM
import uz.lazycoder.playmarketclone.adapters.RvGamesAndAppsTopChartsAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentGamesTopChartsBinding

class GamesTopChartsFragment : Fragment() {

    private lateinit var list: ArrayList<GameAndAppM>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentGamesTopChartsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentGamesTopChartsBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    nested1.visibility = View.VISIBLE

                    rvGamesTopChart.adapter = RvGamesAndAppsTopChartsAdapter(list)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..10) {
                        list.add(
                            GameAndAppM(
                                name = "Clash of Clans",
                                category = getString(R.string.games_categories_15),
                                icon = Consts.iconSmallUrl,
                                rate = "4.6",
                                sizeOrCost = "303 MB"
                            )
                        )

                        list.add(
                            GameAndAppM(
                                name = "PUBG Mobile",
                                category = getString(R.string.games_categories_1),
                                icon = Consts.iconSmallUrl,
                                rate = "4.3",
                                sizeOrCost = "696 MB"
                            )
                        )

                        list.add(
                            GameAndAppM(
                                name = "Asphalt 9: Legends",
                                category = getString(R.string.games_categories_11),
                                icon = Consts.iconSmallUrl,
                                rate = "4.5",
                                sizeOrCost = "2.1 GB"
                            )
                        )

                        list.add(
                            GameAndAppM(
                                name = "Oddmar",
                                category = getString(R.string.games_categories_2),
                                icon = Consts.iconSmallUrl,
                                rate = "4.6",
                                sizeOrCost = "503 MB"
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e: Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.nested1.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}