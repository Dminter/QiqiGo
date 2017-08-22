package com.zncm.dminter.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo1 {

        public static void main(String[] args) {

            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("4");
            list.add("5");
            list.add("9");
            for (String str:list
                 ) {
                if (str.equals("4")){
                    System.out.println(str);
                }
            }
//            Predicate<String> matched = s -> s.equalsIgnoreCase("4");
//            list.filter(matched);
//
//            List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
//            List<String> filteredNames = names
//                    .filter(e -> e.length() >= 4)
//                    .into(new ArrayList<String>());
//            for (String name : filteredNames) {
//                System.out.println(name);
//            }

            }
}
