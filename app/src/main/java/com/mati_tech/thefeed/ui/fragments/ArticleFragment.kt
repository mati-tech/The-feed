package com.mati_tech.thefeed.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgument
import com.google.android.material.snackbar.Snackbar
import com.mati_tech.thefeed.R
import com.mati_tech.thefeed.databinding.FragmentArticleBinding
import com.mati_tech.thefeed.ui.NewsActivity
import com.mati_tech.thefeed.ui.Viewmodels.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewModel : NewsViewModel
    val args : ArticleFragmentArgs by navArgs()
    lateinit var binding : FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let {
                loadUrl(it)
            }
        }
        binding.fab.setOnClickListener{
            newsViewModel.addToFavourite(article)
            Snackbar.make(view, "Added to favourites", Snackbar.LENGTH_LONG).show()
        }
    }
}