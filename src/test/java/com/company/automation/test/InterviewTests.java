package com.company.automation.test;

public class InterviewTests {

    public static void reverseString(String str) {

        String revStr = "";

        for(int i = 0; i<str.length(); i++) {
            revStr = str.charAt(i) + revStr;
        }
        System.out.println(revStr);
    }
    public static void main(String[] args) {
        reverseString("automation testing");
    }
}
