package com.zncm.dminter

import com.zncm.dminter.java.MyDate
import java.util.*

class MyDate2:MyDate(){
    override fun formatDate(date: Date?): String {
   return date.toString()
    }
}

fun main(args: Array<String>) {
    var  mydate=MyDate2()
    println(mydate.formatDate(Date()))
    println(mydate.formatTime(Date()))
//    println(mydate.formatDate(null))
//    println(mydate.formatTime(null))
}
