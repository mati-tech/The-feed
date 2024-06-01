////package com.mati_tech.thefeed.repository
////
////import org.junit.jupiter.api.Assertions.*
////
////class NewsRepositoryTest{
////
////}
//package com.mati_tech.thefeed.repository
//
////import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.lifecycle.LiveData
//import androidx.room.DatabaseConfiguration
//import androidx.room.InvalidationTracker
//import androidx.sqlite.db.SupportSQLiteOpenHelper
//import com.google.common.truth.Truth.assertThat
//import com.mati_tech.thefeed.api.NewsApi
//import com.mati_tech.thefeed.api.RetrofitInstance
//import com.mati_tech.thefeed.db.ArticleDAO
//import com.mati_tech.thefeed.db.ArticleDatabase
//import com.mati_tech.thefeed.models.Article
//import com.mati_tech.thefeed.models.NewsResponse
//import com.mati_tech.thefeed.models.Source
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import org.junit.Assert
////import kotlinx.coroutines.test.runBlockingTest
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import retrofit2.Response
//
//@ExperimentalCoroutinesApi
//class NewsRepositoryTest<MockArticleDao> {
//
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var mockApi: MockNewsAPI
//    private var mockDao: MockArticleDao = TODO()
//    private lateinit var repository: NewsRepository
//
//    @Before
//    fun setUp() {
//        mockApi = MockNewsAPI()
//        mockDao = MockArticleDao()
//        RetrofitInstance.api = mockApi
//        val mockDatabase = MockArticleDatabase(mockDao)
//        repository = NewsRepository(mockDatabase)
//    }
//
//    @Test
//    fun testGetHeadlines(): Unit {
//        val countryCode = "us"
//        val pageNumber = 1
//        Assert.assertTrue(true)
//
//        val result = NewsRepository.getHeadlines(countryCode, pageNumber)
//        assertThat(result.isSuccessful).isTrue()
//        assertThat(result.body()?.articles?.size).isEqualTo(2)
//    }
//
//    @Test
//    fun testUpsert(): Unit  {
//        val article = Article(3, "Author3", "Title3", "Description3", "Url3", Source("iw", "me"), "PublishedAt3", "Content3", "content4")
//        repository.upsert(article)
//
//
//
//    }
//}
//
//// Mock Implementations
//
//class MockNewsAPI : NewsApi {
//     suspend fun getHeadlines(countryCode: String, pageNumber: Int): Response<NewsResponse> {
//        val articles = listOf(
//            Article(1, "Author1", "Title1", "Description1", "Url1", Source("iw", "me"), "PublishedAt1", "Content1", "content4"),
//            Article(2, "Author2", "Title2", "Description2", "Url2", Source("iw", "me"), "PublishedAt2", "Content2", "content4")
//        )
//        val newsResponse = NewsResponse(articles, "ok", 2)
//        return Response.success(newsResponse)
//
//
//     }
//
//    suspend fun searchForNews(searchQuery: String, pageNumber: Int): Response<NewsResponse> {
//        val articles = listOf(
//            Article(1, "Author1", "Title1", "Description1", "Url1", Source("iw", "me"), "PublishedAt1", "Content1", "content4"),
//            Article(2, "Author2", "Title2", "Description2", "Url2", Source("iw", "me"), "PublishedAt2", "Content2", "content4")
//        )
//        val newsResponse = NewsResponse(articles, "ok", 2)
//        return Response.success(newsResponse)
//    }
//
//    override suspend fun getHeadlines(
//        countryCode: String,
//        pageNumber: Int,
//        apiKey: String
//    ): Response<NewsResponse> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun searchForNews(
//        searchQuery: String,
//        pageNumber: Int,
//        apikey: String
//    ): Response<NewsResponse> {
//        TODO("Not yet implemented")
//    }
////}
//
//class MockArticleDao : ArticleDAO {
//    val articles = mutableListOf(
//        Article(1, "Author1", "Title1", "Description1", "Url1", Source("iw", "me"), "PublishedAt1", "Content1", "content4"),
//        Article(2, "Author2", "Title2", "Description2", "Url2", Source("iw", "me"), "PublishedAt2", "Content2", "content4")
//    )
//
//    override suspend fun upsert(article: Article) {
//        articles.add(article)
//    }
//
//    override fun getAllArticles(): LiveData<List<Article>> {
//        TODO("Not yet implemented")
//    }
//
//    override fun getAllArticles(): LiveData<List<Article>> = articles
//
//    override suspend fun deleteArticle(article: Article) {
//        articles.remove(article)
//    }
//}
//
//class MockArticleDatabase() : ArticleDatabase() {
//    override fun getArticleDao(): ArticleDAO {
//        TODO("Not yet implemented")
//    }
//
//    //    override fun getArticleDao(): ArticleDAO = mockArticleDao
//    override fun clearAllTables() {
//        TODO("Not yet implemented")
//    }
//
//    override fun createInvalidationTracker(): InvalidationTracker {
//        TODO("Not yet implemented")
//    }
//
//    override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
//        TODO("Not yet implemented")
//    }
//}
