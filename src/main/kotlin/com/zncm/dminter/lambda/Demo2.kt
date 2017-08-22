package com.zncm.dminter.lambda

import java.util.concurrent.Executors

fun main(args: Array<String>) {
//    testLambda1()
//    lambda2()
    lambda3()
sb3()


}

fun sb3(){
    var s="abcde"
    s= s.subSequence(0,4) as String
    println(s)
}


fun lambda3() {
    val worker = Executors.newCachedThreadPool()
    worker.execute {
        println("Hello")
    }
}

fun lambda2(){
    var list= ArrayList<String>()
    list.add("1")
    list.add("2")
    list.add("5")
    list.add("q")
    list.add("5")
    list.add("0")

    list.forEach{
        print(it)
    }
    println("\n---------------")
    list.forEach(::print)

    println("\n---------------")


    list.forEach {
        if (it.equals("q")) return@forEach
        println(it)
    }
    println("\n---------------")

    list.forEach {
        if (it.equals("q")) return
        println(it)
    }



/**
 *
@kotlin.internal.HidesMembers
public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
for (element in this) action(element)
}
 */



    println("end")
}



private fun testLambda1() {
    var lambda1 = {
        a: Int, b: Int
        ->
        a + b
    }
    println(lambda1(22, 44))
    println(lambda1.invoke(22, 3))
}

