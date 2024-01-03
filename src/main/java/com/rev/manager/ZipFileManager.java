package com.rev.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    public void zipFile() {
        try {
            String sourceFile = System.getProperty("user.dir") + "/report/TestReport-Spark.html";
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/report/testreport.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            File fileToZip = new File(sourceFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[8096];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

            zipOut.close();
            fis.close();
            fos.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
