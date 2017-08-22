package com.zncm.dminter

fun main(args: Array<String>) {


    xx("a_b_c");

}

fun xx(vararg args: String){
    // a_b_c ->a b c
    args.flatMap {
        it.split("_")

    }.map {
        print("$it ")
    }



}



