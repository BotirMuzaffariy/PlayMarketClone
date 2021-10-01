package uz.lazycoder.playmarketclone.ui.apps.editorschoice

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
import uz.lazycoder.playmarketclone.models.GameAndAppInnerSmallM
import uz.lazycoder.playmarketclone.adapters.RvGamesAndAppsKidsAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentAppsEditorsChoiceBinding

class AppsEditorsChoiceFragment : Fragment() {

    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentAppsEditorsChoiceBinding
    private lateinit var appsList: ArrayList<GameAndAppInnerSmallM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentAppsEditorsChoiceBinding.inflate(inflater, container, false)

        loadGameList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvAppsEditorsChoice.visibility = View.VISIBLE

                    rvAppsEditorsChoice.adapter = RvGamesAndAppsKidsAdapter(
                        listOf(getString(R.string.tv_editors_choice)),
                        appsList
                    )
                }
            })
        }

        return binding.root
    }

    private fun loadGameList() {
        appsList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..3) {
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
                binding.rvAppsEditorsChoice.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}