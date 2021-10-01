package uz.lazycoder.playmarketclone.ui.books.genres

import android.os.Bundle
import android.view.View
import android.graphics.Rect
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.adapters.RvCategoriesAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentBooksGenresBinding

class BooksGenresFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var binding: FragmentBooksGenresBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksGenresBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {

            // space item decoration for adapter
            val itemDecoration = object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    val childPosition = parent.getChildAdapterPosition(view)
                    if (childPosition == 0) {
                        outRect.top = 25
                    } else if (childPosition == parent.adapter?.itemCount?.minus(1) ?: 1) {
                        outRect.bottom = 70
                    }
                }
            }

            rvBooksGenres.addItemDecoration(itemDecoration)
            rvBooksGenres.adapter = RvCategoriesAdapter(list)
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.books_genres_1),
            getString(R.string.books_genres_2),
            getString(R.string.books_genres_3),
            getString(R.string.books_genres_4),
            getString(R.string.books_genres_5),
            getString(R.string.books_genres_6),
            getString(R.string.books_genres_7),
            getString(R.string.books_genres_8),
            getString(R.string.books_genres_9),
            getString(R.string.books_genres_10)
        )
    }

}