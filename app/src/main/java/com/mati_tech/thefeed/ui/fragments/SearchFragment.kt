package com.mati_tech.thefeed.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mati_tech.thefeed.R
import com.mati_tech.thefeed.adapters.NewsAdapter
import com.mati_tech.thefeed.api.RetrofitInstance
import com.mati_tech.thefeed.databinding.FragmentSearchBinding
import com.mati_tech.thefeed.ui.NewsActivity
import com.mati_tech.thefeed.ui.Viewmodels.NewsViewModel
import com.mati_tech.thefeed.utill.Constants
import com.mati_tech.thefeed.utill.Constants.Companion.SEARCH_NEWS_TIME_DELAY
import com.mati_tech.thefeed.utill.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Error

class SearchFragment : Fragment(R.layout.fragment_search) {
    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var retryButton: Button
    lateinit var errorText: TextView
    lateinit var itemSearchError: CardView
    lateinit var binding: FragmentSearchBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        itemSearchError = view.findViewById(R.id.itemSearchError)
        val inflater =
            requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.item_error, null)

        retryButton = view.findViewById(R.id.retryButton)
        errorText = view.findViewById(R.id.errorText)

        newsViewModel = (activity as NewsActivity).newsViewModel
        setupSearchRecycler()
        //Here we made an adapter for the handling of clicks on each item of the recycler list of the headline news

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(R.id.action_searchFragment_to_articleFragment)
        }


        //This job is to manage the lifecycle of a coroutine
        var job: Job? = null
        binding.searchEdit.addTextChangedListener(){editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(SEARCH_NEWS_TIME_DELAY)
                editable?.let {
                    if(editable.toString().isNotEmpty()){
                        newsViewModel.searchNews(editable.toString())
                    }
                }

            }
        }

        newsViewModel.searchNews.observe(viewLifecycleOwner, Observer{response ->
            when (response){
                is Resource.Error <*> -> {
                    hideprogressbar()
                    response.message?.let { message ->
                        Toast.makeText(activity, "Sorry error: $message", Toast.LENGTH_LONG).show()
                        showErrorMessage(message)

                    }
                }
                is Resource.Loading <*> ->  {
                    Showprogressbar()
                }
                is Resource.Success<*> -> {
                    // Here if the response is ok
                    //o the followings
                    hideprogressbar()
                    hideErrorMessage()
                    response.date?.let { NewsResponse ->
                        newsAdapter.differ.submitList(NewsResponse.articles.toList())
                        val totalPages = NewsResponse.totalResults / Constants.QUERY_PAGE_SIZE + 2
                        islastpage = newsViewModel.searchNewsPage == totalPages
                        if (islastpage){
                            binding.recyclerSearch.setPadding(0, 0, 0, 0)
                        }

                    }

                }
            }
        })

        retryButton.setOnClickListener{
            if (binding.searchEdit.text.toString().isNotEmpty()) {
                newsViewModel.searchNews(binding.searchEdit.text.toString())

            }else {
                hideErrorMessage()
            }
        }

    }

    // Other functions we need
    var isError = false
    var isloading = false
    var islastpage = false
    var isScrolling = false

    private fun hideprogressbar(){
        binding.paginationProgressBar.visibility = View.INVISIBLE
        isloading = false

    }
    private fun Showprogressbar(){
        binding.paginationProgressBar.visibility = View.VISIBLE
        isloading = true

    }
    private fun hideErrorMessage(){
        itemSearchError.visibility = View.INVISIBLE
        isError = false
    }
    private fun showErrorMessage(message: String){
        itemSearchError.visibility = View.VISIBLE
        errorText.text = message
        isError = true

    }


    val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            //this part create a linear layoutmanager and gets information about
            // first visible item then conditions for errors and last pages

            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.itemCount
            val totalItemCount = layoutManager.itemCount

            val isNoErrors = !isError
            val isNotLoadingAndNotLastPage = !isloading && islastpage
            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
            val isNotAtBeginning = firstVisibleItemPosition >= 0
            val isTotalMoreThanVisible = totalItemCount >= Constants.QUERY_PAGE_SIZE
            val shouldPaginate =
                isNoErrors && isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning && isTotalMoreThanVisible && isScrolling
            if (shouldPaginate) {
                newsViewModel.searchNews(binding.searchEdit.text.toString())
                isScrolling = false
            }


        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            //it handle the user touching the screen from the user inputs
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true

            }
        }
    }

    private fun setupSearchRecycler(){
        newsAdapter = NewsAdapter()
        binding.recyclerSearch.apply {
            //means the items will be listed vertically
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@SearchFragment.scrollListener)
        }
    }

}