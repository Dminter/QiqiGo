package com.zncm.dminter

fun main(args: Array<String>) {

    enum1()
}

fun  enum1(){
    println("enum")
    println(Lang.parse("chinese"))
    println(Lang.parse("KOREAN"))

    var lang =Lang.parse("KOREAN")
    lang.sayHello()
    lang.sayBye()
}

fun Lang.sayBye(){
    var  bye = when(this){
        Lang.CHINESE->"bye bye"
        Lang.CHINESE->"再见"
        Lang.JAPANESE->"DDDD bye bye"
        Lang.KOREAN->"dfsf bye bye"
        else
          ->"再见"
    }
    println(bye)
}

enum class Lang(var  hello:String){
    ENGLISH("hello"),
    CHINESE("你好"),
    JAPANESE("XXXX"),
    KOREAN("sdf23sas");
    fun sayHello(){
        println(hello)
    }
    init {

    }

    companion object{
        fun parse(name:String):Lang{
            return Lang.valueOf(name.toUpperCase())
        }
    }

}



