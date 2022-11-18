package image_downloader.http_util;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {
    private static final HttpStatusChecker HTTP_STATUS_CHECKER = new HttpStatusChecker();

    public void downloadStatusImage(int code) {
        try {
            URL url = new URL(HTTP_STATUS_CHECKER.getStatusImage(code));

            String fileName = "Cat" + code + ".jpg";
            String fileDestinationFolder = "../ImageDownloader/Cat_Images/";

            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream(fileDestinationFolder + fileName);

            byte[] buffer = new byte[2048];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();

            System.out.println("Cat with code " + code + " was downloaded");


        } catch (IOException e) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}

