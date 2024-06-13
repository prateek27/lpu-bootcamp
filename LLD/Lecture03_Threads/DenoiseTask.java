package Lecture03_Threads;

public class DenoiseTask implements Runnable{
    String img;

    DenoiseTask(String img){
        this.img = img;
    }

    @Override
    public void run() {
        //business logic to denoise
        System.out.println("Denoise the img" + this.img + " using" + Thread.currentThread().getName());
    }
}
