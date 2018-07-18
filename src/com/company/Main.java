package com.company;

public class Main {


    public static void main(String[] args) {
        final String PATH = "/home/antn/apps/jdk1.8.0_171/";
        PrintPath printPath = new PrintPath();
        String jdkVersion="jdk1.8.0_171";



        printPath.printFileNames(PATH);


        System.out.println("JDK version on this computer is : " + jdkVersion + "." +
                "\nCount of java files in this directory is : " + printPath.count + ".");
        System.out.println();
        System.out.println("The annotation @FunctionalInterface is find in files :");
        printPath.checkAnnotations(PATH);


    }

}
