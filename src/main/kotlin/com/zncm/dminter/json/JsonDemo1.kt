package com.zncm.dminter.json

import com.google.gson.Gson
import com.zncm.dminter.MyUser
import java.io.File

fun main(args: Array<String>) {
    var json = File(ClassLoader.getSystemResource("userinfo").path).readText();
    println(json)
    var  result =Gson().fromJson(json,MyUser::class.java)
    println(result)

    var  result1:MyUser =Gson().fromJson(json)
    println(result1)





}
