package com.zncm.dminter

import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    println(sum(2, 60))
    println(sum2(20, 60))
    println(sum3(55, 35))
    var1()
    var list = asList(1, 2, 4)
    println(list)
    println(maxOf(111, 222))
    println(maxOf2(231, 222))
    println(toInt("12"))
    println(getStrLen("111"))
    println(getStrLen(123))
    println(getStrLen(12.11))
    for1()
    while1()
    XUtils.while2()
    println(describe(1))
    println(describe(133))
    println(describe("222"))
    println(describe("hello"))
    range1()
}


fun range1() {
    var x = 5
    var y = 10
    if (x in 1..y) {
        print("ok")
    }
    for (z in 1..5) {
        print(z)
    }

    for (x in 1..10 step 2) {
        print(x)
    }
    for (x in 9 downTo 0 step 3) {
        print(x)
    }

}


fun describe(obj: Any): String =
        when (obj) {
            1 -> "ONE"
            "hello" -> "OK"
            is Long -> "LONG"
            is String -> "OKOK"
            else -> "UNKNOWN"
        }


object XUtils {
    fun while2() {

        val items = listOf("AAA", "BBB", "CCC")
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }

    }

    fun while3() {

        val items = listOf("AAA", "BBB", "CCC")
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }

    }
}


fun while1() {

    val items = listOf("AAA", "BBB", "CCC")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

}

fun for1() {
    val items = listOf("A", "B", "C")
    for (item in items) {
        print(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}


fun getStrLen(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}


fun toInt(str: String): Int? {
    return parseInt(str)

}


fun maxOf2(a: Int, b: Int) = if (a > b) a else b


fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}


fun <T> asList(vararg ts: T): List<T> {
    var ret = ArrayList<T>()
    for (t in ts)
        ret.add(t)
    return ret
}


class person {
    var name: String = "jmx"
    var age: Int = 2
}

fun var1() {
    val a: Int = 10
    var b = 4
    var c: Int
    c = 3
    var d = "222"
    var x = 101
    x += 1
    println(a)
    println(b)
    println(c)
    println(d)
    println(x)
}


fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun sum3(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}
