package uz.lazycoder.playmarketclone.ui.movies.foryou

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
import uz.lazycoder.playmarketclone.databinding.FragmentMoviesForYouBinding

class MoviesForYouFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentMoviesForYouBinding
    private lateinit var movieAndBookList: ArrayList<MovieAndBookM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentMoviesForYouBinding.inflate(inflater, container, false)

        loadList()
        loadMovieList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvMoviesForYou.visibility = View.VISIBLE

                    rvMoviesForYou.adapter = RvMoviesAdapter(list, movieAndBookList)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.movies_for_you_section_1),
            getString(R.string.movies_for_you_section_2),
            getString(R.string.movies_for_you_section_3),
            getString(R.string.movies_for_you_section_4),
            getString(R.string.movies_for_you_section_5),
            getString(R.string.movies_for_you_section_6)
        )
    }

    private fun loadMovieList() {
        movieAndBookList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..15) {
                        movieAndBookList.add(
                            MovieAndBookM(
                                name = "Infinite",
                                cost = "UZS 70,200",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        movieAndBookList.add(
                            MovieAndBookM(
                                name = "Minions",
                                cost = "UZS 16,800",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        movieAndBookList.add(
                            MovieAndBookM(
                                name = "1917",
                                cost = "UZS 19,800",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        movieAndBookList.add(
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
                binding.rvMoviesForYou.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }
    }

}