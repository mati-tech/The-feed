package com.mati_tech.thefeed.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mati_tech.thefeed.models.Article


@Database(entities = [Article::class],
    version =1
)

//Here we need the typeconverter to be mentioned also
//bcz to tell the database that we have a data model which is not an ordinary data

@TypeConverters(Converters::class)

//we need to make it an abstract class as we will implement an abstract method in it later
abstract class ArticleDatabase:RoomDatabase() {
    abstract fun getArticleDao(): ArticleDAO
    // to have it everywhere in the class we need a companian object
    companion object{
        //volatile ensures that the changes made by this thread is visible to the other threads
        // instance holds the instance of database or a null
        // lock object used to ensure that only one block of the code can be executed at a time

        @Volatile
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()
        // this one is used to make the database and ensures that only one block at at time is run
        // first by using question mark it checks if the instance is already been made if not create one

        operator fun invoke(context:Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{
                instance = it
            }
        }
        // above code is for the thread safety
        // last one using builder starts the database

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }

}