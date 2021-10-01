package uz.lazycoder.playmarketclone.ui.apps.categories

import android.os.Bundle
import android.view.View
import android.graphics.Rect
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import androidx.recyclerview.widget.RecyclerView
import uz.lazycoder.playmarketclone.adapters.RvCategoriesAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentAppsCategoriesBinding

class AppsCategoriesFragment : Fragment() {

    private lateinit var list: List<String>
    private lateinit var binding: FragmentAppsCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAppsCategoriesBinding.inflate(inflater, container, false)

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

            rvAppsCategories.addItemDecoration(itemDecoration)
            rvAppsCategories.adapter = RvCategoriesAdapter(list)
        }

        return binding.root
    }

    private fun loadList() {
        list = listOf(
            getString(R.string.apps_category_1),
            getString(R.string.apps_category_2),
            getString(R.string.apps_category_3),
            getString(R.string.apps_category_4),
            getString(R.string.apps_category_5),
            getString(R.string.apps_category_6),
            getString(R.string.apps_category_7),
            getString(R.string.apps_category_8),
            getString(R.string.apps_category_9),
            getString(R.string.apps_category_10),
            getString(R.string.apps_category_11),
            getString(R.string.apps_category_12),
            getString(R.string.apps_category_13),
            getString(R.string.apps_category_14),
            getString(R.string.apps_category_15),
            getString(R.string.apps_category_16),
            getString(R.string.apps_category_17),
            getString(R.string.apps_category_18),
            getString(R.string.apps_category_19),
            getString(R.string.apps_category_20),
            getString(R.string.apps_category_21),
            getString(R.string.apps_category_22),
            getString(R.string.apps_category_23),
            getString(R.string.apps_category_24),
            getString(R.string.apps_category_25),
            getString(R.string.apps_category_26),
            getString(R.string.apps_category_27),
            getString(R.string.apps_category_28),
            getString(R.string.apps_category_29),
            getString(R.string.apps_category_30),
            getString(R.string.apps_category_31),
            getString(R.string.apps_category_32),
            getString(R.string.apps_category_33),
            getString(R.string.apps_category_34),
            getString(R.string.apps_category_35)
        )
    }

}