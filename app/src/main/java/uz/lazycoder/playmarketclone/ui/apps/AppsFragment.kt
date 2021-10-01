package uz.lazycoder.playmarketclone.ui.apps

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import uz.lazycoder.playmarketclone.MainActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import uz.lazycoder.playmarketclone.adapters.apps.VpAppsAdapter
import uz.lazycoder.playmarketclone.databinding.FragmentAppsBinding

class AppsFragment : Fragment() {

    private lateinit var tlList: List<String>
    private lateinit var binding: FragmentAppsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).showBottomNav()
        binding = FragmentAppsBinding.inflate(inflater, container, false)

        loadList()

        binding.apply {
            vp2Apps.isUserInputEnabled = false
            vp2Apps.adapter = VpAppsAdapter(requireActivity())

            TabLayoutMediator(tlApps, vp2Apps) { tab, position ->
                tab.text = tlList[position]
            }.attach()

            iSearch.cvMoreImg.setOnClickListener { findNavController().navigate(R.id.moreFunctionsFragment) }
        }

        return binding.root
    }

    private fun loadList() {
        tlList = listOf(
            getString(R.string.apps_tab_text_1),
            getString(R.string.apps_tab_text_2),
            getString(R.string.apps_tab_text_3),
            getString(R.string.apps_tab_text_4),
            getString(R.string.apps_tab_text_5)
        )
    }

}