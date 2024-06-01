package com.mati_tech.thefeed.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


//The article is the entity we wanna save it in the database
//Here we need to have the primary key for the table which can be a zero and auto generated

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
): Serializable


//Source is not the datatype which can be used in our database
// we need to convert it in a form that can be used
// for that we need to first serialize the whole data we have