package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class PrintPath {

    public int count=0;

    public void printFileNames(String sDir){
        File[] faFiles = new File(sDir).listFiles();
        for(File file: faFiles){
            if(file.isFile()){
                if(file.getAbsolutePath().contains(".jar")){
                    count++;
                }
            }
            if(file.isDirectory()){
                printFileNames(file.getAbsolutePath());
            }
        }
    }

    public void checkAnnotations(String sDir){
        File[] faFiles = new File(sDir).listFiles();
        for(File file: faFiles){
            if(file.isFile()){
                if(file.getAbsolutePath().contains(".jar")){
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String currentLine;
                        while ((currentLine = br.readLine()) != null) {
                            if(currentLine.contains("@FunctionalInterface")) {
                                System.out.println(file.getAbsolutePath());
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(file.isDirectory()){
                checkAnnotations(file.getAbsolutePath());
            }
        }
    }


}
