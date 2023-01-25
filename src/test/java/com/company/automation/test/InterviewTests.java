package com.company.automation.test;

public class InterviewTests {
     public static void main(String[] args) {

         String str = "automation";
         String revStr = "";

         for(int i=str.length()-1; i>=0; i--) {
             revStr = revStr + i;
         }
         System.out.println(revStr);
    }
}
