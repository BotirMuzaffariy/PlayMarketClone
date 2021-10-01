package uz.lazycoder.playmarketclone.ui.movies.newreleases

import android.os.Bundle
import android.view.View
import java.lang.Exception
import android.view.ViewGroup
import kotlinx.coroutines.launch
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import uz.lazycoder.playmarketclone.R
import kotlinx.coroutines.coroutineScope
import androidx.lifecycle.MutableLiveData
import uz.lazycoder.playmarketclone.utils.Consts
import uz.lazycoder.playmarketclone.utils.showToast
import uz.lazycoder.playmarketclone.models.movies.MovieAndBookM
import uz.lazycoder.playmarketclone.adapters.RvMoviesAndBooksTopAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentMoviesNewReleasesBinding

class MoviesNewReleasesFragment : Fragment() {

    private lateinit var list: ArrayList<MovieAndBookM>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentMoviesNewReleasesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentMoviesNewReleasesBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    nested1.visibility = View.VISIBLE

                    rvMoviesNewReleases.adapter = RvMoviesAndBooksTopAdapter(list)
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
                            MovieAndBookM(
                                "Infinite",
                                "UZS 70,200",
                                "2.6",
                                getString(R.string.movies_genres_1),
                                Consts.movieAndBookUrl
                            )
                        )

                        list.add(
                            MovieAndBookM(
                                "Minions",
                                "UZS 16,800",
                                "4.3",
                                getString(R.string.movies_genres_3),
                                Consts.movieAndBookUrl
                            )
                        )

                        list.add(
                            MovieAndBookM(
                                "1917",
                                "UZS 19,800",
                                "4.0",
                                getString(R.string.movies_genres_1),
                                Consts.movieAndBookUrl
                            )
                        )

                        list.add(
                            MovieAndBookM(
                                "The Boss Baby",
                                "UZS 16,500",
                                "4.6",
                                getString(R.string.movies_genres_2),
                                Consts.movieAndBookUrl
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