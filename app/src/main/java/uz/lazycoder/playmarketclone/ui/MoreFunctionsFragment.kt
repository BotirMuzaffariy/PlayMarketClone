package uz.lazycoder.playmarketclone.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import uz.lazycoder.playmarketclone.MainActivity
import androidx.navigation.fragment.findNavController
import uz.lazycoder.playmarketclone.databinding.FragmentMoreFunctionsBinding

class MoreFunctionsFragment : Fragment() {

    private lateinit var binding: FragmentMoreFunctionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).hideBottomNav()
        binding = FragmentMoreFunctionsBinding.inflate(inflater, container, false)

        binding.apply {
            cvClose.setOnClickListener { findNavController().popBackStack() }
            llSettings.setOnClickListener { findNavController().navigate(R.id.settingsFragment) }
        }

        return binding.root
    }

}