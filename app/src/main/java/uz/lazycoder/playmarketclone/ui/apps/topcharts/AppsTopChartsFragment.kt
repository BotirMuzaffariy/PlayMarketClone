package uz.lazycoder.playmarketclone.ui.apps.topcharts

import android.os.Bundle
import android.view.View
import java.lang.Exception
import android.view.ViewGroup
import kotlinx.coroutines.launch
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import androidx.lifecycle.MutableLiveData
import uz.lazycoder.playmarketclone.utils.Consts
import uz.lazycoder.playmarketclone.utils.showToast
import uz.lazycoder.playmarketclone.models.GameAndAppM
import uz.lazycoder.playmarketclone.adapters.RvGamesAndAppsTopChartsAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentAppsTopChartsBinding

class AppsTopChartsFragment : Fragment() {

    private lateinit var list: ArrayList<GameAndAppM>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentAppsTopChartsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentAppsTopChartsBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    nested1.visibility = View.VISIBLE

                    rvAppsTopChart.adapter = RvGamesAndAppsTopChartsAdapter(list)
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
                                name = "Instagram",
                                category = getString(R.string.apps_category_30),
                                icon = Consts.iconSmallUrl,
                                rate = "3.8",
                                sizeOrCost = "235 MB"
                            )
                        )

                        list.add(
                            GameAndAppM(
                                name = "Telegram",
                                category = getString(R.string.apps_category_9),
                                icon = Consts.iconSmallUrl,
                                rate = "4.3",
                                sizeOrCost = "25 MB"
                            )
                        )

                        list.add(
                            GameAndAppM(
                                name = "Shazam: Discover songs & lyrics",
                                category = getString(R.string.apps_category_23),
                                icon = Consts.iconSmallUrl,
                                rate = "4.8",
                                sizeOrCost = "7.2 MB"
                            )
                        )

                        list.add(
                            GameAndAppM(
                                name = "Yandex. Navigator",
                                category = getString(R.string.apps_category_21),
                                icon = Consts.iconSmallUrl,
                                rate = "4.6",
                                sizeOrCost = "91 MB"
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