package com.zncm.dminter

import jdk.nashorn.internal.codegen.CompilerConstants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//https://api.github.com/repos/enbandari/Kotlin-Tutorials/stargazers
interface MyGitHubService{
//    @GET("/repos/enbandari/Kotlin-Tutorials/stargazers")
//    fun getUserList(): CompilerConstants.Call<List<MyUser>>
}

object MyService{
    val getMyGitHubService:MyGitHubService by lazy{
        Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create()).build().create(MyGitHubService::class.java)
    }
}

fun main(args: Array<String>) {
//    MyService.getMyGitHubService.getUserList().execute().body().map (::println)
}