package uz.lazycoder.playmarketclone.ui.games.categories

import android.os.Bundle
import android.view.View
import android.graphics.Rect
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.adapters.RvCategoriesAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentGamesCategoriesBinding

class GamesCategoriesFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var binding: FragmentGamesCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGamesCategoriesBinding.inflate(inflater, container, false)

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

            rvGamesCategories.addItemDecoration(itemDecoration)
            rvGamesCategories.adapter = RvCategoriesAdapter(list)
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.games_categories_1),
            getString(R.string.games_categories_2),
            getString(R.string.games_categories_3),
            getString(R.string.games_categories_4),
            getString(R.string.games_categories_5),
            getString(R.string.games_categories_6),
            getString(R.string.games_categories_7),
            getString(R.string.games_categories_8),
            getString(R.string.games_categories_9),
            getString(R.string.games_categories_10),
            getString(R.string.games_categories_11),
            getString(R.string.games_categories_12),
            getString(R.string.games_categories_13),
            getString(R.string.games_categories_14),
            getString(R.string.games_categories_15),
            getString(R.string.games_categories_16),
            getString(R.string.games_categories_17)
        )
    }

}