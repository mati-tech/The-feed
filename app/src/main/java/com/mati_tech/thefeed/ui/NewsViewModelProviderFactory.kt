package com.mati_tech.thefeed.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mati_tech.thefeed.repository.NewsRepository
import com.mati_tech.thefeed.ui.Viewmodels.NewsViewModel


//this is the class which is instantiate and return our view model

class NewsViewModelProviderFactory(val app: Application, val newsRepository: NewsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app, newsRepository) as T
    }
}