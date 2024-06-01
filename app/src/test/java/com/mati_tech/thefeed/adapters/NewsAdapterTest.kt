//package com.mati_tech.thefeed.adapters
//
//import android.widget.TextView
//import org.junit.Assert.*
//
//import org.junit.Test
//
//
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.google.common.truth.Truth.assertThat
//import com.mati_tech.thefeed.R
//import com.mati_tech.thefeed.models.Article
//import org.junit.Before
//
////import org.robolectric.Robolectric
////import org.robolectric.RobolectricTestRunner
////import org.robolectric.annotation.Config
//
////@Config(manifest = Config.NONE)
////@RunWith(RobolectricTestRunner::class)
//class NewsAdapterTest {
//
//    private lateinit var adapter: NewsAdapter
//
//    @Before
//    fun setUp() {
//        adapter = NewsAdapter()
//    }
//
//    @Test
//    fun testOnCreateViewHolder() {
//        assertTrue(true)
//
//        val parent = Robolectric.buildActivity(NewsAdapter::class.java).get().findViewById<RecyclerView>(R.id.recyclerView)
//        val viewHolder = adapter.onCreateViewHolder(parent, 0)
//        assertThat(viewHolder).isNotNull()
//    }
//
//    @Test
//    fun testGetItemCount() {
//        assertTrue(true)
//
//        val articles = listOf(
//            Article(1, "Author1", "Title1", "Description1", "Url1", "UrlToImage1", "PublishedAt1", "Content1"),
//            Article(2, "Author2", "Title2", "Description2", "Url2", "UrlToImage2", "PublishedAt2", "Content2")
//        )
//        adapter.differ.submitList(articles)
//        assertThat(adapter.itemCount).isEqualTo(articles.size)
//    }
//
//    @Test
//    fun testOnBindViewHolder() {
//        assertTrue(true)
//
//        val articles = listOf(
//            Article(1, "Author1", "Title1", "Description1", "Url1", "UrlToImage1", "PublishedAt1", "Content1"),
//            Article(2, "Author2", "Title2", "Description2", "Url2", "UrlToImage2", "PublishedAt2", "Content2")
//        )
//        adapter.differ.submitList(articles)
//
//        val parent = Robolectric.buildActivity(NewsAdapter::class.java).get().findViewById<RecyclerView>(R.id.recyclerView)
//        val viewHolder = adapter.onCreateViewHolder(parent, 0)
//        adapter.onBindViewHolder(viewHolder, 0)
//
//        val itemView = viewHolder.itemView
//        assertThat(itemView.findViewById<TextView>(R.id.articleTitle).text).isEqualTo("Title1")
//        assertThat(itemView.findViewById<TextView>(R.id.articleSource).text).isEqualTo("Unknown Source")
//        assertThat(itemView.findViewById<TextView>(R.id.articleDescription).text).isEqualTo("Description1")
//        assertThat(itemView.findViewById<TextView>(R.id.articleDateTime).text).isEqualTo("PublishedAt1")
//    }
//}
