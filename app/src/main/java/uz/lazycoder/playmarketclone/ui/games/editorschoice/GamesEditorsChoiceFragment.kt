package uz.lazycoder.playmarketclone.ui.games.editorschoice

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
import uz.lazycoder.playmarketclone.databinding.FragmentGamesEditorsChoiceBinding

class GamesEditorsChoiceFragment : Fragment() {

    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentGamesEditorsChoiceBinding
    private lateinit var gamesList: ArrayList<GameAndAppInnerSmallM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentGamesEditorsChoiceBinding.inflate(inflater, container, false)

        loadGameList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvGamesEditors.visibility = View.VISIBLE

                    rvGamesEditors.adapter = RvGamesAndAppsKidsAdapter(
                        listOf(getString(R.string.tv_editors_choice)),
                        gamesList
                    )
                }
            })
        }

        return binding.root
    }

    private fun loadGameList() {
        gamesList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..3) {
                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "Clash of Clans",
                                "295 MB",
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
                                "2.1 GB",
                                Consts.iconNormalUrl
                            )
                        )

                        gamesList.add(
                            GameAndAppInnerSmallM(
                                "Oddmar",
                                "110 MB",
                                Consts.iconNormalUrl
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e: Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.rvGamesEditors.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}