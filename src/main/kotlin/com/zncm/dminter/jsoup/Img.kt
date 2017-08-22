package com.zncm.dminter.jsoup

import com.zncm.dminter.for1
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.io.FileWriter
import java.io.BufferedWriter
import jdk.nashorn.internal.runtime.ScriptingFunctions.readLine
import org.jsoup.select.Elements
import java.io.FileReader
import java.io.BufferedReader
import java.io.File


fun main(args: Array<String>) {
//    println("111")
//    randomImg()
//    diglweb()
//baike()
//    toutiao()
    juejin()
}

fun contentToTxt(filePath: String, content: String) {
    var s1 = String()//内容更新
    try {
        val f = File(filePath)
        //            f.deleteOnExit();
        if (!f.exists()) {
            f.createNewFile()
        }
        val input = BufferedReader(FileReader(f))
        s1 = input.readText()
//        while (str != null) {
//            s1 += str + "\n"
//        }
//        println(s1)
        input.close()
        s1 += content
        val output = BufferedWriter(FileWriter(f))
        output.write(s1)
        output.close()
    } catch (e: Exception) {
        e.printStackTrace()

    }

}


fun baike() {

//    http://www.chinabaike.com/zhi/sort_type-new_recommend__day-0__is_recommend-0__page-4
    try {
        var url = "http://www.chinabaike.com/zhi/sort_type-new_recommend__day-0__is_recommend-0__page-4"
        var doc: Document
        doc = Jsoup.connect(url).timeout(5000).get()
//            println(url+"   " +doc.text())
        var out = doc.getElementsByClass("aw-item").get(0).text()

        println(out)


    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun toutiao() {

//    http://www.chinabaike.com/zhi/sort_type-new_recommend__day-0__is_recommend-0__page-4
    try {
        var url = "https://toutiao.io/"
        var doc: Document
        doc = Jsoup.connect(url).timeout(5000).get()
        println(url + "   " + doc.text())
        var out = doc.getElementsByClass("content").get(0).text()

        println(out)


    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun juejin() {

//    http://www.chinabaike.com/zhi/sort_type-new_recommend__day-0__is_recommend-0__page-4
    try {
//
        /**
         *http://zuimeia.com/apps/?platform=2 app-title
         *  http://www.ifanr.com/app      article-item
         *
         *
         */


        var url = "http://m.thepaper.cn/"
        var doc: Document
        doc = Jsoup.connect(url).timeout(5000).get()
            println(url+"   " +doc.text())

        var elementsKey = "li"

        var elements = doc.select(elementsKey)

        println("select")
        if (elements == null || elements.size == 0) {
            println("getElementsByClass")
            elements = doc.getElementsByClass(elementsKey)
        }
        if (elements == null || elements.size == 0) {
            println("getElementsByTag")
            elements = doc.getElementsByTag(elementsKey)
        }
        if (elements == null || elements.size == 0) {
            println("getElementsByAttribute")
            elements = doc.getElementsByAttribute(elementsKey)
        }



        println(elements)


    } catch (e: Exception) {
        e.printStackTrace()
    }
}


/**
 *http://diglweb.zjlib.net.cn:8081/zjtsg/fjzj/fjzjd.jsp?record=1
 * 西湖香市        唐宋时，西湖天竺、灵隐、昭庆、净慈等寺院已有香会。南宋偏安杭州，历代皇帝往往亲临礼佛，文武百官也去拈香。民间相沿成习。     西湖香市始于花朝（二月十二，即所谓“百花生日”），尽于端午（五月初五）。以“天竺香市”为最早。二月十九观音诞辰，村民以一村一庄，结伙成队，乘坐香船来杭。进香路线，城内以吴山各寺庙，城外以天竺和灵隐、净慈、昭庆、圣因四大丛林为主。烧大蜡烛的，只有天竺一处。此外，还有所谓的“三山香市”。三山者即天竺山的观音、小和山的玄天上帝、法华山的东岳大帝。进香队伍由长者领头带路，数十成群，肩挂黄包包袱，腰系红带，头裹白毛巾，在一天之内，来回百余里，烧遍三山之香，名曰“翻三山”。香客沿途踏青赏春，自有一番情趣。    
 */
fun diglweb() {
    try {
        var sbInfo = StringBuffer()
        for (record in 1..1479) {
            var url = "http://diglweb.zjlib.net.cn:8081/zjtsg/fjzj/fjzjd.jsp?record=" + record + "&back=-1&channelid=70122"
            var doc: Document
            doc = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0").timeout(5000).get()
//            println(url+"   " +doc.text())
            /**
             *-->资源出处:浙江风俗简志 <<上一记录 下一记录>>
             *     风景浙江_细览页面
             */
            var text = doc.text()
            if (text != null && text.length > 0) {
                if (text.contains(Regex("-->.*>>"))) {
                    text = text.replace(Regex("-->.*>>"), "")
                }
                if (text.contains("风景浙江_细览页面")) {
                    text = text.replace("风景浙江_细览页面", "")
                }
                if (text.contains("--")) {
                    text = text.replace("--", "")
                }
//                sbInfo.append(text)
                println(text)
//                contentToTxt("D:\\Dev\\MyKotlin\\file\\1.txt", text);
            }

        }


    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun randomImg() {
    try {
        val url = "https://alpha.wallhaven.cc/random"
        val doc: Document
        doc = Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0").timeout(5000).get()
        System.out.println(doc.html())
        val srcLinks = doc.select("a[href]")
        for (link in srcLinks) {
            System.out.println("imagesPath==>" + link.html())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}