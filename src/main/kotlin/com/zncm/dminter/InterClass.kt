package com.zncm.dminter
internal class InterClass{
    fun xxx(){
        println("XXX")
    }
    internal fun balabala(){
        println("balabala")
    }
}

fun main(args: Array<String>) {
    balabala()
}

internal fun balabala(){
    println("balabala")
}