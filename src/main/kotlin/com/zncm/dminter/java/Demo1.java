package com.zncm.dminter.java;

import com.zncm.dminter.*;

public class Demo1 {
    public static void main(String args[]){
        System.out.println("hello java");
        MyUser myUser = new MyUser("111",111,"3333333");
        System.out.println("user："+myUser);


        Singleton.INSTANCE.hello();


        SumAB sumAB = new SumAB();
        sumAB.sumab(1,4);
        sumAB.sumab(3);
        PackKt.helloPkg();

        System.out.println(ExMethodKt.notEmpty("hello"));
        System.out.println(ExMethodKt.notEmpty(""));

        InterClass interClass =new InterClass();
        interClass.xxx();
//        interClass.balabala$production_sources_for_module_MyKotlin_main();
    }
}
