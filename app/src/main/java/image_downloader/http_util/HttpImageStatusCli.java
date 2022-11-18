package image_downloader.http_util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private static final HttpStatusImageDownloader HTTP_STATUS_IMAGE_DOWNLOADER = new HttpStatusImageDownloader();

    public void askStatus(){
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter HTTP status code");
            int code = scanner.nextInt();
            HTTP_STATUS_IMAGE_DOWNLOADER.downloadStatusImage(code);

        } catch (InputMismatchException ex) {
            System.out.println("Please enter valid number");
        }
    }
}
