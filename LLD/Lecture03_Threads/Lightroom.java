package Lecture03_Threads;

public class Lightroom {
    public static void main(String[] args) {
        //Main - UI
        //Denoise
        //Upload Photos
        Thread uploadPhotosThread = new Thread(new UploadPhotosTask());
        Thread denoisePhotoThread = new Thread(new DenoiseTask("dog.jpg"));

        String imgs[] = {"a.png","b.png","c.png"};

        denoisePhotoThread.start();
        uploadPhotosThread.start();
        System.out.println("Main is running!" + Thread.currentThread().getName());
    }
}
