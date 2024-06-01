//package com.mati_tech.thefeed.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.AsyncListDiffer
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
////import com.bumptech.glide.Glide
//import com.mati_tech.thefeed.R
//import com.mati_tech.thefeed.models.Article
//
//class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
//    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
//    lateinit var articleImage: ImageView
//    lateinit var articleSource: TextView
//    lateinit var articleTitle: TextView
//    lateinit var articleDescription: TextView
//    lateinit var articleDateTime : TextView
//
//    //automatically refresh the recycle list
//    // the interface is used to check the diff between two list
//    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
//        // these methods checks the items of the list
//        // or has been moved
//        // the other one checks all the contents of the list
//        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
//            return oldItem.url == newItem.url
//        }
//
//        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    // this one is in the background task
//    val differ = AsyncListDiffer(this, differCallback)
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
//        //here at the end will return a view item_news
//        return ArticleViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
//        )
//    }
//
//
//    override fun getItemCount(): Int {
//        return differ.currentList.size
//    }
//
//
////    take an article and make it a unit which does not return anything
//    private var onItemClickListener: ((Article) -> Unit)? = null
//
//    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
//
//        //first it will retrieve the object from the current  position of the list using the differ
//        val article = differ.currentList[position]
//
//        articleImage = holder.itemView.findViewById(R.id.articleImage)
//        articleSource = holder.itemView.findViewById(R.id.articleSource)
//        articleTitle = holder.itemView.findViewById(R.id.articleTitle)
//        articleDescription = holder.itemView.findViewById(R.id.articleDescription)
//        articleDateTime = holder.itemView.findViewById(R.id.articleDateTime)
//
//        //Above all are the views and below are all the data
//
//
//        //here we have the Glide to load the image into the imageview
//        holder.itemView.apply {
//
//            Glide.with(this).load(article.urlToImage).into(articleImage)
//
////            if (!imageUrl.isNullOrEmpty()) {
////            } else {
////                // Set a placeholder image or handle the null/empty URL case
////                articleImage.setImageResource(R.drawable.news_item_backup) // Replace with your placeholder image resource
////            }
//
////            Glide.with(this).load(article.urlToImage).into(articleImage)
//            articleSource.text = article.source?.name ?: "Unknown Source"
//            articleTitle.text = article.title ?: "No Title"
//            articleDescription.text = article.description ?: "No Description"
//            articleDateTime.text = article.publishedAt ?: "Unknown Date"
//
//            setOnClickListener {
//                onItemClickListener?.let {
//                    it (article)}
//            }
//        }
//
//    }
//    fun setOnItemClickListener(listener: (Article)-> Unit){
//        onItemClickListener = listener
//    }
//}



//-------
//
//
//package com.mati_tech.thefeed.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.AsyncListDiffer
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.mati_tech.thefeed.R
//import com.mati_tech.thefeed.models.Article
//
//class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
//
//    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val articleImage: ImageView = itemView.findViewById(R.id.articleImage)
//        val articleSource: TextView = itemView.findViewById(R.id.articleSource)
//        val articleTitle: TextView = itemView.findViewById(R.id.articleTitle)
//        val articleDescription: TextView = itemView.findViewById(R.id.articleDescription)
//        val articleDateTime: TextView = itemView.findViewById(R.id.articleDateTime)
//    }
//
//    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
//        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
//            return oldItem.url == newItem.url
//        }
//
//        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, differCallback)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
//        return ArticleViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return differ.currentList.size
//    }
//
//    private var onItemClickListener: ((Article) -> Unit)? = null
//
//    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
//        val article = differ.currentList[position]
//
//        holder.itemView.apply {
//            Glide.with(this).load(article.urlToImage).into(holder.articleImage)
//            holder.articleSource.text = article.source?.name ?: "Unknown Source"
//            holder.articleTitle.text = article.title ?: "No Title"
//            holder.articleDescription.text = article.description ?: "No Description"
//            holder.articleDateTime.text = article.publishedAt ?: "Unknown Date"
//
//            setOnClickListener {
//                onItemClickListener?.let { it(article) }
//            }
//        }
//    }
//
//    fun setOnItemClickListener(listener: (Article) -> Unit) {
//        onItemClickListener = listener
//    }
//}

package com.mati_tech.thefeed.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mati_tech.thefeed.R
import com.mati_tech.thefeed.models.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val articleImage: ImageView = itemView.findViewById(R.id.articleImage)
        val articleSource: TextView = itemView.findViewById(R.id.articleSource)
        val articleTitle: TextView = itemView.findViewById(R.id.articleTitle)
        val articleDescription: TextView = itemView.findViewById(R.id.articleDescription)
        val articleDateTime: TextView = itemView.findViewById(R.id.articleDateTime)
    }

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage ).into(holder.articleImage)
            holder.articleSource.text = article.source?.name ?: "Unknown Source"
            holder.articleTitle.text = article.title ?: "No Title"
            holder.articleDescription.text = article.description ?: "No Description"
            holder.articleDateTime.text = article.publishedAt ?: "Unknown Date"

            setOnClickListener {
                onItemClickListener?.let { it(article) }
            }
        }
    }

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}

