package com.zncm.dminter.java;

import java.util.HashMap;
import java.util.Map;

public class KeyDemo {
        public static void main(String[] args) {
            Map<String,String> map = new HashMap<>();
            map.put("4=4","123");
            if (map.containsKey("4=4")){
                System.out.println("1");
            }else {
                System.out.println("2");
            }
            }
}
