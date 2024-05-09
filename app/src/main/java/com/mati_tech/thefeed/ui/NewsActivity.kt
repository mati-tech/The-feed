package com.mati_tech.thefeed.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mati_tech.thefeed.R
import com.mati_tech.thefeed.databinding.ActivityNewsBinding
import com.mati_tech.thefeed.db.ArticleDatabase
import com.mati_tech.thefeed.models.Article
import com.mati_tech.thefeed.repository.NewsRespository
import com.mati_tech.thefeed.ui.Viewmodels.NewsViewModel

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding
    //Custom Factory allows you to control over the dependecies
    //it gives you the opportunity to manage as you want

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
//        enableEdgeToEdge()

        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRespository = NewsRespository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRespository)
        newsViewModel = ViewModelProvider (this, viewModelProviderFactory)[NewsViewModel::class.java]

        // Here we use nav host fragment from support fragment manager
        // the navcontroller is responsible for the handling of all the navs in the graph we made

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

    }
}