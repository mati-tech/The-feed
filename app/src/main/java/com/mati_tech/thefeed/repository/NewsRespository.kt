package com.mati_tech.thefeed.repository
// A place or container where our news is stored

import android.icu.text.StringSearch
import com.mati_tech.thefeed.api.RetrofitInstance
import com.mati_tech.thefeed.db.ArticleDatabase
import com.mati_tech.thefeed.models.Article
import java.util.Locale.IsoCountryCode
//suspend ensures that the function is done in the background thread
class NewsRespository (val db: ArticleDatabase){
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    //upsert with article
    suspend fun upset(article: Article) = db.getArticleDao().upsert(article)

    // for invoking method for favorite articles
    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}