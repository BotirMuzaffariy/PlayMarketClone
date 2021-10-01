package uz.lazycoder.playmarketclone.ui.books.foryou

import android.os.Bundle
import android.view.View
import java.lang.Exception
import android.view.ViewGroup
import kotlinx.coroutines.launch
import android.view.LayoutInflater
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import uz.lazycoder.playmarketclone.R
import androidx.fragment.app.Fragment
import kotlinx.coroutines.coroutineScope
import androidx.lifecycle.MutableLiveData
import uz.lazycoder.playmarketclone.utils.Consts
import uz.lazycoder.playmarketclone.utils.showToast
import uz.lazycoder.playmarketclone.models.movies.MovieAndBookM
import uz.lazycoder.playmarketclone.adapters.books.RvBooksForYouAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentBooksForYouBinding

class BooksForYouFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var liveData: MutableLiveData<Boolean>
    private lateinit var booksList: ArrayList<MovieAndBookM>
    private lateinit var binding: FragmentBooksForYouBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        liveData = MutableLiveData()
        binding = FragmentBooksForYouBinding.inflate(inflater, container, false)

        loadList()
        loadBooksList()

        binding.apply {
            liveData.observe(viewLifecycleOwner, {
                if (it) {
                    pbLoad.visibility = View.GONE
                    rvBooksForYou.visibility = View.VISIBLE

                    rvBooksForYou.adapter = RvBooksForYouAdapter(list, booksList)
                }
            })
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.books_for_you_section_1),
            getString(R.string.books_for_you_section_2),
            getString(R.string.books_for_you_section_3),
            getString(R.string.books_for_you_section_4),
            getString(R.string.books_for_you_section_5),
            getString(R.string.books_for_you_section_6)
        )
    }

    private fun loadBooksList() {
        booksList = ArrayList()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                coroutineScope {
                    for (i in 1..15) {
                        booksList.add(
                            MovieAndBookM(
                                name = "MAQSAD",
                                cost = getString(R.string.tv_free),
                                rate = "4.6",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        booksList.add(
                            MovieAndBookM(
                                name = "The Art of War",
                                cost = "$2.99",
                                rate = "4.4",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        booksList.add(
                            MovieAndBookM(
                                name = "Think and Grow Rich",
                                cost = "$0.99",
                                rate = "4.5",
                                image = Consts.movieAndBookUrl
                            )
                        )

                        booksList.add(
                            MovieAndBookM(
                                name = "Expert Secrets",
                                cost = "$20.99",
                                rate = "4.4",
                                image = Consts.movieAndBookUrl
                            )
                        )
                    }

                    liveData.value = true
                }
            } catch (e: Exception) {
                binding.pbLoad.visibility = View.GONE
                binding.rvBooksForYou.visibility = View.GONE
                showToast(e.message ?: getString(R.string.tv_error))
            }
        }

    }

}