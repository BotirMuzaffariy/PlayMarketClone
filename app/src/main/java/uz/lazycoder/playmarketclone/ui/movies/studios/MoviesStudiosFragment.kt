package uz.lazycoder.playmarketclone.ui.movies.studios

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
import uz.lazycoder.playmarketclone.adapters.movies.RvMoviesAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentMoviesStudiosBinding

class MoviesStudiosFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var movieList: ArrayList<MovieAndBookM>
    private lateinit var binding: FragmentMoviesStudiosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentMoviesStudiosBinding.inflate(inflater, container, false)

        loadList()
        loadMovieList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvMoviesStudios.visibility = View.VISIBLE

                    rvMoviesStudios.adapter = RvMoviesAdapter(list, movieList)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.movies_studios_section_1),
            getString(R.string.movies_studios_section_2),
            getString(R.string.movies_studios_section_3),
            getString(R.string.movies_studios_section_4),
            getString(R.string.movies_studios_section_5),
            getString(R.string.movies_studios_section_6)
        )
    }

    private fun loadMovieList() {
        movieList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..15) {
                        movieList.add(
                            MovieAndBookM(
                                name = "Infinite",
                                cost = "UZS 70,200",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        movieList.add(
                            MovieAndBookM(
                                name = "Minions",
                                cost = "UZS 16,800",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        movieList.add(
                            MovieAndBookM(
                                name = "1917",
                                cost = "UZS 19,800",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        movieList.add(
                            MovieAndBookM(
                                name = "The Boss Baby",
                                cost = "UZS 16,500",
                                image = Consts.movieAndBookUrl
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e: Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.rvMoviesStudios.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}