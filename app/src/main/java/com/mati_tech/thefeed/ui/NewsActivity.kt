package com.mati_tech.thefeed.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.mati_tech.thefeed.R
import com.mati_tech.thefeed.databinding.ActivityNewsBinding
import com.mati_tech.thefeed.db.ArticleDatabase
import com.mati_tech.thefeed.repository.NewsRepository
import com.mati_tech.thefeed.ui.Viewmodels.NewsViewModel

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding
//    lateinit var toolbar: Toolbar
    lateinit var main_page_drawer: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var actionBar: ActionBar


    //Custom Factory allows you to control over the dependecies
    //it gives you the opportunity to manage as you want

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_news)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        main_page_drawer = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.drawer_menu_left_main_page)

        toggle = ActionBarDrawerToggle(
            this@NewsActivity,
            main_page_drawer,
            0,
            0)
        main_page_drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        actionBar = supportActionBar!!
        actionBar.title = "The Feed"

        navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item -> // Handle navigation item clicks
            if (item.itemId == R.id.drawer_profile) {
                val intent = Intent(this@NewsActivity, ProfileActivity::class.java )
                startActivity(intent)

            }  else if (item.itemId == R.id.drawer_about_us) {
                val intent = Intent(this@NewsActivity, AboutUsActivity::class.java)
                startActivity(intent)
            }
            main_page_drawer.closeDrawers()
            true
        })




        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel = ViewModelProvider (this, viewModelProviderFactory)[NewsViewModel::class.java]

        // Here we use nav host fragment from support fragment manager
        // the navcontroller is responsible for the handling of all the navs in the graph we made

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)




    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Pass the event to the ActionBarDrawerToggle, if it returns true, then it has handled the app icon touch event
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}