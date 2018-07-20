package com.company;


import java.io.IOException;

public class Main {


    public static void main(String[] args) {

        final String PATH = "/home/antn/apps/jdk1.8.0_171/";
        final String ZIP_PATH = "/home/antn/apps/jdk1.8.0_171/src.zip";
        PrintPath printPath = new PrintPath();

        try {
            printPath.extractRarFile(ZIP_PATH, PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jdkVersion = "jdk1.8.0_171";
        printPath.printFileNames(PATH);
        System.out.println("JDK version on this computer is : " + jdkVersion + "." +
                "\nCount of java files in this directory is : " + printPath.count + ".");
        System.out.println();
        System.out.println("The annotation @FunctionalInterface is find in files :");
        printPath.checkAnnotations(PATH);


    }

}
