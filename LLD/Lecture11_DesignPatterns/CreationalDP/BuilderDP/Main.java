package Lecture11_DesignPatterns.CreationalDP.BuilderDP;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car.CarBuilder("100C","TataNexon")
                .setAirConditioning(true)
                .build();

        Car c2 = new Car.CarBuilder("100C","Tata")
                .setAirConditioning(false)
                .setSunRoof(true)
                .build();

        Car c3 = new Car.CarBuilder("120C","Toyata")
                .setAirConditioning(false)
                .setSunRoof(true)
                .setGPS(true)
                .build();


        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
