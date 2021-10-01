package uz.lazycoder.playmarketclone.ui.books

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import uz.lazycoder.playmarketclone.MainActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import uz.lazycoder.playmarketclone.adapters.books.VpBooksAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentBooksBinding

class BooksFragment : Fragment() {

    private lateinit var tlList: List<String>
    private lateinit var binding: FragmentBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).showBottomNav()
        binding = FragmentBooksBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {
            vp2Books.isUserInputEnabled = false
            iSearch.tvHint.text = getString(R.string.search_books)

            vp2Books.adapter = VpBooksAdapter(requireActivity())

            TabLayoutMediator(tlBooks, vp2Books) { tab, position ->
                tab.text = tlList[position]
            }.attach()

            iSearch.cvMoreImg.setOnClickListener { findNavController().navigate(R.id.moreFunctionsFragment) }
        }

        return binding.root
    }

    private fun loadList() {
        tlList = listOf(
            getString(R.string.books_tab_text_1),
            getString(R.string.books_tab_text_2),
            getString(R.string.books_tab_text_3),
            getString(R.string.books_tab_text_4),
            getString(R.string.books_tab_text_5)
        )
    }

}