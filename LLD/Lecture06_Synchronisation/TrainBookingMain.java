package Lecture06_Synchronisation;

public class TrainBookingMain {
    public static void main(String[] args) throws InterruptedException {
        TrainReservation tr = new TrainReservation();
        tr.displayAvailableSeats();


        Thread u1 = new Thread(()->{
            tr.bookSeats("1AC",3);
        });
        Thread u2 = new Thread(()->{
            tr.bookSeats("1AC",3);
        });
        Thread u3 = new Thread(()->{
            tr.bookSeats("2AC",5);
        });
        Thread u4 = new Thread(()->{
            tr.bookSeats("2AC",5);
        });
        Thread u5 = new Thread(()->{
            tr.bookSeats("Sleeper",50);
        });

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();

        u1.join();
        u2.join();
        u3.join();
        u4.join();
        u5.join();

        tr.displayAvailableSeats();
    }
}
