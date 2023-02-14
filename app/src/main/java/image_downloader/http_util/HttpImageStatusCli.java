package image_downloader.http_util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private static final HttpStatusImageDownloader HTTP_STATUS_IMAGE_DOWNLOADER = new HttpStatusImageDownloader();

    public static void askStatus() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter HTTP status code");
            int code = 0;

            boolean inputMismatch = true;
            while (inputMismatch) {
                if (scanner.hasNextInt())
                    code = scanner.nextInt();
                else {
                    System.err.println("Please enter valid number");
                    scanner.next();
                    continue;
                }
                inputMismatch = false;
            }

            HTTP_STATUS_IMAGE_DOWNLOADER.downloadStatusImage(code);
            askStatus();

        } catch (InputMismatchException ex) {
            ex.printStackTrace();
        }
    }
}
