package dminter.jsonpath;

import com.zf.zson.ZSON;
import com.zf.zson.result.ZsonResult;

public class Demo1
{


        public static void main(String[] args) {


            String json = "{\n" +
                    "    \"store\": {\n" +
                    "        \"book\": [\n" +
                    "            {\n" +
                    "                \"category\": \"reference\",\n" +
                    "                \"author\": \"Nigel Rees\",\n" +
                    "                \"title\": \"Sayings of the Century\",\n" +
                    "                \"price\": 8.95\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"category\": \"fiction\",\n" +
                    "                \"author\": \"Evelyn Waugh\",\n" +
                    "                \"title\": \"Sword of Honour\",\n" +
                    "                \"price\": 12.99\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"category\": \"fiction\",\n" +
                    "                \"author\": \"Herman Melville\",\n" +
                    "                \"title\": \"Moby Dick\",\n" +
                    "                \"isbn\": \"0-553-21311-3\",\n" +
                    "                \"price\": 8.99\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"category\": \"fiction\",\n" +
                    "                \"author\": \"J. R. R. Tolkien\",\n" +
                    "                \"title\": \"The Lord of the Rings\",\n" +
                    "                \"isbn\": \"0-395-19395-8\",\n" +
                    "                \"price\": 22.99\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"bicycle\": {\n" +
                    "            \"color\": \"red\",\n" +
                    "            \"price\": 19.95\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"expensive\": 10\n" +
                    "}";


            try {

//                List<String> authors = JsonPath.read(json, "$.store.book[*].author");
//                List<String> authors = JsonPath.read(json, "$.store.book[*].author");
                ZsonResult zr = ZSON.parseJson(json);
                 System.out.println(zr.getValues("//book"));
            }catch (Exception e){
                e.printStackTrace();
            }



            }
}
