package uz.lazycoder.playmarketclone.ui.settings

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.app.AlertDialog
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.lazycoder.playmarketclone.R
import uz.lazycoder.playmarketclone.utils.Utils
import uz.lazycoder.playmarketclone.MainActivity
import uz.lazycoder.playmarketclone.utils.Consts
import androidx.navigation.fragment.findNavController
import uz.lazycoder.playmarketclone.utils.MySharedPrefs
import uz.lazycoder.playmarketclone.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var mainActivity: MainActivity
    private lateinit var sharedPrefs: MySharedPrefs
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainActivity = (requireActivity() as MainActivity)
        sharedPrefs = MySharedPrefs.getInstance(requireContext())
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        setTexts()

        binding.apply {
            cvBack.setOnClickListener { findNavController().popBackStack() }

            llTheme.setOnClickListener {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle(requireContext().getString(R.string.tv_theme))

                val checkedItem = when (sharedPrefs.getTheme()) {
                    Consts.THEME_LIGHT -> 0
                    Consts.THEME_DARK -> 1
                    Consts.THEME_SYSTEM -> 2
                    else -> 2
                }

                builder.setSingleChoiceItems(
                    arrayOf(
                        getString(R.string.theme_light),
                        getString(R.string.theme_dark),
                        getString(R.string.theme_system)
                    ), checkedItem
                ) { dialog, position ->
                    dialog.dismiss()
                    Utils.changeTheme(requireContext(), position)

                    tvTheme.text = when (position) {
                        0 -> getString(R.string.theme_light)
                        1 -> getString(R.string.theme_dark)
                        2 -> getString(R.string.theme_system)
                        else -> getString(R.string.theme_system)
                    }
                }

                builder.setNegativeButton(getString(R.string.tv_cancel)) { dialog, _ -> dialog.dismiss() }
                builder.show()
            }

            llLanguage.setOnClickListener {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle(getString(R.string.tv_language))

                val checkedItem = when (sharedPrefs.getLanguage()) {
                    Consts.LANG_EN -> 0
                    Consts.LANG_RU -> 1
                    Consts.LANG_UZ -> 2
                    else -> 0
                }

                builder.setSingleChoiceItems(
                    arrayOf("English", "Русский", "O`zbekcha"),
                    checkedItem
                ) { dialog, position ->
                    dialog.dismiss()

                    when (position) {
                        0 -> Utils.changeLanguage(requireContext(), "en")
                        1 -> Utils.changeLanguage(requireContext(), "ru")
                        2 -> Utils.changeLanguage(requireContext(), "uz")
                    }

                    mainActivity.recreate()
                }

                builder.setNegativeButton(getString(R.string.tv_cancel)) { dialog, _ -> dialog.dismiss() }
                builder.show()
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        mainActivity.hideBottomNav()
    }

    private fun setTexts() {
        binding.apply {
            tvTop.text = getString(R.string.tv_settings)
            tvTitleTheme.text = getString(R.string.tv_theme)
            tvTitleLanguage.text = getString(R.string.tv_language)

            tvTheme.text = when (sharedPrefs.getTheme()) {
                Consts.THEME_LIGHT -> getString(R.string.theme_light)
                Consts.THEME_DARK -> getString(R.string.theme_dark)
                Consts.THEME_SYSTEM -> getString(R.string.theme_system)
                else -> getString(R.string.theme_system)
            }

            tvLanguage.text = when (sharedPrefs.getLanguage()) {
                Consts.LANG_EN -> "English"
                Consts.LANG_RU -> "Русский"
                Consts.LANG_UZ -> "O`zbekcha"
                else -> "English"
            }
        }
    }

}