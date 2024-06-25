package Lecture11_DesignPatterns.DirectionService;

public class DirectionServiceDemo {
    public static void main(String[] args) {
        DirectionService ds = new DirectionService();
        ds.setTravelMode(new Walk());
        ds.getEta();
        ds.getDirection();
    }
}
