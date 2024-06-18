package Lecture06_Synchronisation;

//one train will have multiple seat types
// 1AC - 100 ,2AC - 11 , 3AC - 300, Sleeper-500
// U1 - 1AC 5 seats
// U2 - 2 AC 3 seats U3 - 2AC 10 seats


import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TrainReservation {
    HashMap<String,Integer> availableSeats;
    HashMap<String, ReentrantLock> seatLocks;

    TrainReservation(){
        availableSeats = new HashMap<>();
        availableSeats.put("2AC",10);
        availableSeats.put("3AC",20);
        availableSeats.put("Sleeper",40);
        availableSeats.put("1AC",5);

        //init the lock hashmap
        seatLocks = new HashMap<>();
        for(String key: availableSeats.keySet()){
            seatLocks.put(key,new ReentrantLock());
        }
    }

    void bookSeats(String seatType, int qty){
            ReentrantLock lock = seatLocks.get(seatType);
            lock.lock();
            if(availableSeats.get(seatType)>=qty){
                int currentAvailable = availableSeats.get(seatType);
                availableSeats.put(seatType,currentAvailable-qty);
            }
            else{
                System.out.println("Enough seats not available");
            }
            lock.unlock();
    }

    void displayAvailableSeats(){
        System.out.println(availableSeats);
    }
}
