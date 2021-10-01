package uz.lazycoder.playmarketclone.ui.apps.kids

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
import uz.lazycoder.playmarketclone.databinding.FragmentAppsKidsBinding

class AppsKidsFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var binding: FragmentAppsKidsBinding
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var appsList: ArrayList<GameAndAppInnerSmallM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentAppsKidsBinding.inflate(inflater, container, false)

        loadList()
        loadAppsList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvAppsKids.visibility = View.VISIBLE

                    rvAppsKids.adapter = RvGamesAndAppsKidsAdapter(list, appsList)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.apps_kids_section_1),
            getString(R.string.apps_kids_section_2),
            getString(R.string.apps_kids_section_3),
            getString(R.string.apps_kids_section_4),
            getString(R.string.apps_kids_section_6)
        )
    }

    private fun loadAppsList() {
        appsList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..13) {
                        appsList.add(
                            GameAndAppInnerSmallM(
                                "Instagram",
                                "235 MB",
                                Consts.iconNormalUrl
                            )
                        )

                        appsList.add(
                            GameAndAppInnerSmallM(
                                "Telegram",
                                "25 MB",
                                Consts.iconNormalUrl
                            )
                        )

                        appsList.add(
                            GameAndAppInnerSmallM(
                                "Shazam: Discover songs & lyrics",
                                "7.2 MB",
                                Consts.iconNormalUrl
                            )
                        )

                        appsList.add(
                            GameAndAppInnerSmallM(
                                "Yandex. Navigator",
                                "91 MB",
                                Consts.iconNormalUrl
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e: Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.rvAppsKids.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}