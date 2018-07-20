package com.company;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

public class ZipContents {

    private static final int BUFFER_SIZE = 4096;


    public static void extract(ZipInputStream zip, String path) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        byte[] bytes = new byte[BUFFER_SIZE];
        int length;
        while ((length = zip.read(bytes)) > 0) bos.write(bytes, 0, length);
        bos.close();
    }
}
