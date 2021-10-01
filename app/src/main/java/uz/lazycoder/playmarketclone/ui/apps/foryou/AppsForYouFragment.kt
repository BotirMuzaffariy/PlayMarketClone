package uz.lazycoder.playmarketclone.ui.apps.foryou

import android.os.Bundle
import android.view.View
import kotlinx.coroutines.*
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.lifecycle.MutableLiveData
import uz.lazycoder.playmarketclone.models.TypeM
import uz.lazycoder.playmarketclone.utils.Consts
import uz.lazycoder.playmarketclone.utils.showToast
import uz.lazycoder.playmarketclone.models.GameAndAppM
import uz.lazycoder.playmarketclone.adapters.apps.RvAppsForYouAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentAppsForYouBinding

class AppsForYouFragment : Fragment() {

    private lateinit var list: ArrayList<TypeM>
    private lateinit var appsList: ArrayList<GameAndAppM>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentAppsForYouBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentAppsForYouBinding.inflate(inflater, container, false)

        loadList()
        loadAppsList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvAppsForYou.visibility = View.VISIBLE

                    rvAppsForYou.adapter = RvAppsForYouAdapter(list, appsList)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = ArrayList()
        list.add(TypeM(getString(R.string.apps_for_you_section_1), "def"))
        list.add(TypeM(getString(R.string.apps_for_you_section_2), ""))
        list.add(TypeM(getString(R.string.apps_for_you_section_3), "def"))
        list.add(TypeM(getString(R.string.apps_for_you_section_4), "def"))
        list.add(TypeM(getString(R.string.apps_for_you_section_5), ""))
        list.add(TypeM(getString(R.string.apps_for_you_section_6), "def"))
    }

    private fun loadAppsList() {
        appsList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..15) {
                        appsList.add(
                            GameAndAppM(
                                "Instagram",
                                getString(R.string.apps_category_30),
                                listOf(getString(R.string.apps_category_9)),
                                Consts.iconNormalUrl,
                                "3.8",
                                "235 MB",
                                Consts.screenshotUrl
                            )
                        )

                        appsList.add(
                            GameAndAppM(
                                "Telegram",
                                getString(R.string.apps_category_9),
                                listOf(),
                                Consts.iconNormalUrl,
                                "4.3",
                                "25 MB",
                                Consts.screenshotUrl
                            )
                        )

                        appsList.add(
                            GameAndAppM(
                                "Shazam: Discover songs & lyrics",
                                getString(R.string.apps_category_23),
                                listOf(getString(R.string.apps_category_32)),
                                Consts.iconNormalUrl,
                                "4.8",
                                "7.2 MB",
                                Consts.screenshotUrl
                            )
                        )

                        appsList.add(
                            GameAndAppM(
                                "Yandex. Navigator",
                                getString(R.string.apps_category_21),
                                listOf(getString(R.string.apps_category_32)),
                                Consts.iconNormalUrl,
                                "4.6",
                                "91 MB",
                                Consts.screenshotUrl
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e: Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.rvAppsForYou.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}