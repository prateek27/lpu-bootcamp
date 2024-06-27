package Lecture11_DesignPatterns.CreationalDP.BuilderDP;

public class Car {
    private String engine;
    private String name;
    private boolean airConditioning;
    private boolean sunRoof;
    private boolean GPS;

    private Car(CarBuilder builder){
        this.engine = builder.engine;
        this.name = builder.name;
        this.airConditioning = builder.airConditioning;
        this.sunRoof = builder.sunRoof;
        this.GPS = builder.GPS;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", name='" + name + '\'' +
                ", airConditioning=" + airConditioning +
                ", sunRoof=" + sunRoof +
                ", GPS=" + GPS +
                '}';
    }

    //Another Class CarBuilder
    public static class CarBuilder{
        private String engine;
        private String name;
        private boolean airConditioning;
        private boolean sunRoof;
        private boolean GPS;

        public CarBuilder(String engine,String name){
            this.name = name;
            this.engine = engine;
        }

        public CarBuilder setAirConditioning(boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }
        public CarBuilder setSunRoof(boolean sunRoof){
            this.sunRoof = sunRoof;
            return this;
        }
        public CarBuilder setGPS(boolean gps){
            this.GPS = gps;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    }

}
