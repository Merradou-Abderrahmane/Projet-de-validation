package com.example.projet_validation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.projet_validation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the navigation host fragment from this Activity
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // Instantiate the navController using the NavHostFragment
        navController = navHostFragment.navController
        // Make sure actions in the ActionBar get propagated to the NavController
        setupActionBarWithNavController(navController)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


         //Inflate the menu to add items to the action bar
        menuInflater.inflate(R.menu.menu, menu)


        // Find the search menu item and set its icon

        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        return when (item.itemId) {
            R.id.action_favorite -> {
                navController.navigate(R.id.favoritelistFragment)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
 }

}
