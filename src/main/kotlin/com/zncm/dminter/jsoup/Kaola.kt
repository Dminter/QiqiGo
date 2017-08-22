package com.zncm.dminter.jsoup

import com.alibaba.fastjson.JSON
import com.zncm.dminter.for1
import dminter.utils.Xutils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.*
import java.util.ArrayList



fun main(args: Array<String>) {

    /**
     *考拉FM API
    http://api.kaolafm.com/api/v4/audios/list?id=1100000000207
     */
    getInfo()

}
private fun getInfo() {

    try {




        for(id in 1100000000000..1100000003000) {
            var str =""
//            id = "1100000000106"
            val url = "http://api.kaolafm.com/api/v4/audios/list?sorttype=10&pagesize=10&pagenum=1&id="+id
            val  doc: Document
            doc = Jsoup.connect(url).ignoreContentType(true).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0").timeout(5000).get()
            var ret = JSON.parseObject(doc.text()).getString("result")
            ret = JSON.parseObject(ret).getString("dataList")

//        Xutils.debug(ret)
            val kaolas = JSON.parseArray(ret, Kaola::class.java) as ArrayList<Kaola>
            if (kaolas!=null) {
                for (tmp in kaolas) {
                    System.out.println(tmp.audioName+" "+id)
                    str+= tmp.audioName+" "+id+"\n"
                }
                System.out.println()
                str+="\n"
            }
            contentToTxt("D:\\Dev\\QiqiGo\\file\\1100000003000.txt",str)
        }





//        System.out.println(doc.html())



    }catch (e:Exception){
        e.printStackTrace()
    }

}