package com.mati_tech.thefeed.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.mati_tech.thefeed.models.Article
import androidx.room.Query

//This is the data access point, where we write the query for database
// we have the interface for it
//using room library
@Dao
interface ArticleDAO {
    // Insert to insert into database, the onconflict will replace if duplicate

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    //    the suspend suggests that wil be called using the coroutines
    suspend fun upsert(article: Article): Long

    // we query the articles
    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    // for deleting the data from database
    @Delete
    suspend fun deleteArticle(article: Article)



}