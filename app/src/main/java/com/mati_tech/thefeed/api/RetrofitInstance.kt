package com.mati_tech.thefeed.api

import com.google.gson.Gson
import com.mati_tech.thefeed.utill.Constants.Companion.Base_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private val retrofit by lazy {
            // lazillay initialized when first accessed the retrofit
            // then a logging is created to intercept the http
//            then an okay http is created
            val logging = HttpLoggingInterceptor()
// a retrofit is used to configure the base url
//            and then the gson

            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()


            Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        }
        // Here we build another lazy foor api which uses retrofit for the api configuration

        val api by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}