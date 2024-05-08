package com.mati_tech.thefeed.utill


//This one is used for representing the different state while fetching the data from the resource
//like success or failed

sealed class Resource <T>(
    //here we made generic class of T, for the result data of the operation
    // also we have three classes for the success, error and the loading

    val date: T? = null,
    val message: String? = null
){
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message:String, data: T?= null): Resource<T>(data, message)
    class Loading<T>: Resource<T>()

}


