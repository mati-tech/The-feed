package com.mati_tech.thefeed.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mati_tech.thefeed.R
import com.mati_tech.thefeed.adapters.NewsAdapter
import com.mati_tech.thefeed.databinding.FragmentFavouriteBinding
import com.mati_tech.thefeed.ui.NewsActivity
import com.mati_tech.thefeed.ui.Viewmodels.NewsViewModel
import java.util.Spliterator.OfLong

class FavouriteFragment : Fragment(R.layout.fragment_favourite) {
    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var binding: FragmentFavouriteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteBinding.bind(view)


        newsViewModel = (activity as NewsActivity).newsViewModel
        setupFavoriteRecycler()
        //Here we made an adapter for the handling of clicks on each item of the recycler list of the headline news

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(R.id.action_favouriteFragment_to_articleFragment)
        }


        //here for swiping right and left to delete the fav article

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true

            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = newsAdapter.differ.currentList[position]
                newsViewModel.deleteArticle(article)
                Snackbar.make(view, "Removed from favourites", Snackbar.LENGTH_LONG).apply {
                    setAction("Undo") {
                        newsViewModel.addToFavourite(article)

                    }
                    show()

                }
            }

        }
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.recyclerFavourites)
        }
        newsViewModel.getFavouriteNews().observe(viewLifecycleOwner, Observer { articles ->
            newsAdapter.differ.submitList(articles)
        })
    }


    private fun setupFavoriteRecycler(){
        newsAdapter = NewsAdapter()
        binding.recyclerFavourites.apply {
            //means the items will be listed vertically
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)



        }

    }


}