package com.company;

public class Main {


    public static void main(String[] args) {

        PrintPath printPath = new PrintPath();
        String jdkVersion="jdk1.8.0_171";
        printPath.printFnames("/home/antn/apps/jdk1.8.0_171/");
        System.out.println("The JDK version on this computer is : " + jdkVersion + "." +
                "\nCount of java files in this directory is : " + printPath.count + ".");



    }

}
