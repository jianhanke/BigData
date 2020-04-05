package com.atguigu.Test01;


import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
       System.out.println("Tdsfsdfa");

       String[] strs={"3123","312"};
       String[] strs2=new String[20];
       for(String str:strs){
           System.out.println(str);
       }
        strs2[1]="31231";
       strs2[2]="fadsaf";
       System.out.println(Arrays.toString(strs2));


    }
}
