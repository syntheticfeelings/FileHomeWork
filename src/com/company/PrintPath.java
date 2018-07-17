package com.company;

import java.io.File;



public class PrintPath {

    public int count=0;

    public void printFnames(String sDir){
        File[] faFiles = new File(sDir).listFiles();
        for(File file: faFiles){
            if(file.isFile()){
//                System.out.println(file.getAbsolutePath());
                if(file.getAbsolutePath().contains(".jar")){
                    count++;
                }
            }
            if(file.isDirectory()){
                printFnames(file.getAbsolutePath());
            }
        }
    }
}
