package com.zncm.dminter

import com.zncm.dminter.java.JavaUser

fun main(args: Array<String>) {
    val user = JavaUser();
    user.id =1
    user.name="balabala"
    println(user.id)
    println(user.name)

    println(user.str)
    var  mystr:String = user.str
    println(mystr)


}
