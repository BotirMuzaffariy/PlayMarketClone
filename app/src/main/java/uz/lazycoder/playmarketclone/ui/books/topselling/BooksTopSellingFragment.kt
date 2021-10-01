package uz.lazycoder.playmarketclone.ui.books.topselling

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
import uz.lazycoder.playmarketclone.databinding.FragmentBooksTopSellingBinding

class BooksTopSellingFragment : Fragment() {

    private lateinit var list: ArrayList<MovieAndBookM>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var binding: FragmentBooksTopSellingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentBooksTopSellingBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    nested1.visibility = View.VISIBLE

                    rvBooksTopSelling.adapter = RvMoviesAndBooksTopAdapter(list)
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
                                "MAQSAD",
                                getString(R.string.tv_free),
                                "4.6",
                                "Shahbozbek Dolimov",
                                Consts.movieAndBookUrl
                            )
                        )

                        list.add(
                            MovieAndBookM(
                                "The Art of War",
                                "$2.99",
                                "4.4",
                                "Sun Tzu",
                                Consts.movieAndBookUrl
                            )
                        )

                        list.add(
                            MovieAndBookM(
                                "Think and Grow Rich",
                                "$0.99",
                                "4.5",
                                "Napoleon Hill",
                                Consts.movieAndBookUrl
                            )
                        )

                        list.add(
                            MovieAndBookM(
                                "Expert Secrets",
                                "$20.99",
                                "4.4",
                                "Russell Brunson",
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