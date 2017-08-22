package com.zncm.dminter

import java.math.BigInteger

fun main(args: Array<String>) {

    println(jiecheng(0))
    println(jiecheng(5))
//    println(jiecheng(10000000))
    var result = Result()
//    jiecheng3(100000, result)
//    jiecheng3(8, result)
    println(result.value)
}

fun jiecheng(num: Int): BigInteger {
    if (num == 0) return BigInteger.valueOf(1L)
    return BigInteger.valueOf(num.toLong()).times(jiecheng((num - 1)))
}

tailrec fun jiecheng2(num: Int): BigInteger {
    if (num == 0) return BigInteger.valueOf(1L)
    return BigInteger.valueOf(num.toLong()).times(jiecheng((num - 1)))
}

tailrec fun jiecheng3(num: Int, result: Result) {
    if (num == 0) result.value = result.value.times(BigInteger.valueOf(1L)) else {
        result.value = result.value.times(BigInteger.valueOf(num.toLong()))
        jiecheng3(num - 1, result)
    }


}


class Result(var value: BigInteger = BigInteger.valueOf(1L))

