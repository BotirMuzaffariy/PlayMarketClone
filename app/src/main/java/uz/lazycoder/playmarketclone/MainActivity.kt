package uz.lazycoder.playmarketclone

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.NavController
import androidx.appcompat.app.AppCompatActivity
import uz.lazycoder.playmarketclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.my_nav_host)

        binding.apply {
            bottomNavView.itemTextColor = null
            bottomNavView.itemIconTintList = null

            bottomNavView.setOnItemSelectedListener {
                if (it.itemId != bottomNavView.selectedItemId) {
                    when (it.itemId) {
                        R.id.m_games -> {
                            navController.popBackStack()
                            navController.navigate(R.id.gamesFragment)
                            bottomNavView.itemTextAppearanceActive = R.style.BottomNavTextActiveGreen
                        }
                        R.id.m_apps -> {
                            navController.popBackStack()
                            navController.navigate(R.id.appsFragment)
                            bottomNavView.itemTextAppearanceActive = R.style.BottomNavTextActiveGreen
                        }
                        R.id.m_movies -> {
                            navController.popBackStack()
                            navController.navigate(R.id.moviesFragment)
                            bottomNavView.itemTextAppearanceActive = R.style.BottomNavTextActivePink
                        }
                        R.id.m_books -> {
                            navController.popBackStack()
                            navController.navigate(R.id.booksFragment)
                            bottomNavView.itemTextAppearanceActive = R.style.BottomNavTextActiveBlue
                        }
                    }
                }
                true
            }
        }

    }

    override fun onResume() {
        super.onResume()

        binding.apply {
            when (bottomNavView.selectedItemId) {
                R.id.m_games -> bottomNavView.itemTextAppearanceActive = R.style.BottomNavTextActiveGreen
                R.id.m_apps -> bottomNavView.itemTextAppearanceActive = R.style.BottomNavTextActiveGreen
                R.id.m_movies -> bottomNavView.itemTextAppearanceActive = R.style.BottomNavTextActivePink
                R.id.m_books -> bottomNavView.itemTextAppearanceActive = R.style.BottomNavTextActiveBlue
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    fun hideBottomNav() {
        if (::binding.isInitialized) {
            binding.bottomNavView.visibility = View.GONE
        }
    }

    fun showBottomNav() {
        if (::binding.isInitialized) {
            binding.bottomNavView.visibility = View.VISIBLE
        }
    }

}