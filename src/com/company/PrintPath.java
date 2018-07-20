package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class PrintPath {

    public int count = 0;

    public void extractRarFile(String archive, String dest) throws IOException {
        File path = new File(dest);
        if (!path.exists()) path.mkdir();

        ZipInputStream zip = new ZipInputStream(new FileInputStream(archive));
        ZipEntry entry = zip.getNextEntry();

        while (entry != null) {
            String content = dest + File.separator + entry.getName();
            System.out.println("Extract: " + entry.getName());
            if (!entry.isDirectory()) ZipContents.extract(zip, content);
            else {
                File dir = new File(content);
                dir.mkdir();
            }
            zip.closeEntry();
            entry = zip.getNextEntry();
        }
        zip.close();
    }

    public void printFileNames(String sDir) {
        File[] faFiles = new File(sDir).listFiles();
        for (File file : faFiles) {
            if (file.isFile()) {
                if (file.getAbsolutePath().contains(".java")) {
                    count++;
                }
            }
            if (file.isDirectory()) {
                printFileNames(file.getAbsolutePath());
            }
        }
    }

    public void checkAnnotations(String sDir) {
        File[] faFiles = new File(sDir).listFiles();
        for (File file : faFiles) {
            if (file.isFile()) {
                if (file.getAbsolutePath().contains(".java")) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String currentLine;
                        while ((currentLine = br.readLine()) != null) {
                            if (currentLine.contains("@FunctionalInterface")) {
                                System.out.println(file.getAbsolutePath());
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (file.isDirectory()) {
                checkAnnotations(file.getAbsolutePath());
            }
        }
    }


}
