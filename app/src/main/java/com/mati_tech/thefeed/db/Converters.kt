package com.mati_tech.thefeed.db

import androidx.room.TypeConverters
import com.mati_tech.thefeed.models.Source


class Converters {
// Here we first tell compiler that it is a typeconverter
    //then fun from source which converts the source name
    // the source has two fields, first was not important which is id
    // second one we took the name of source
    @TypeConverters
    fun fromsource(source: Source):String {
        return source.name
    }

    @TypeConverters
    fun tosource(name:String):Source{
        return Source(name, name)
    }
}