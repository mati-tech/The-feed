package com.mati_tech.thefeed.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.mati_tech.thefeed.models.Source


class Converters {
// Here we first tell compiler that it is a typeconverter
    //then fun from source which converts the source name
    // the source has two fields, first was not important which is id
    // second one we took the name of source
    @TypeConverter
    fun fromSource(source: Source):String {
        return source.name
    }

    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name, name)
    }
}