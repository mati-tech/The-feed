package com.mati_tech.thefeed.api

import com.mati_tech.thefeed.models.NewsResponse
import com.mati_tech.thefeed.utill.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        //here we customize the url
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apiKey: String = API_KEY

    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery:String,
        @Query("page")
        pageNumber: Int =1 ,
        @Query("apikey")
        apikey :String = API_KEY
    ): Response<NewsResponse>

}