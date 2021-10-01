package uz.lazycoder.playmarketclone.ui.movies.genres

import android.os.Bundle
import android.view.View
import android.graphics.Rect
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.adapters.RvCategoriesAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentMoviesGenresBinding

class MoviesGenresFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var binding: FragmentMoviesGenresBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesGenresBinding.inflate(inflater, container, false)

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

            rvMoviesGenres.addItemDecoration(itemDecoration)
            rvMoviesGenres.adapter = RvCategoriesAdapter(list)
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.movies_genres_1),
            getString(R.string.movies_genres_2),
            getString(R.string.movies_genres_3),
            getString(R.string.movies_genres_4),
            getString(R.string.movies_genres_5),
            getString(R.string.movies_genres_6),
            getString(R.string.movies_genres_7)
        )
    }

}