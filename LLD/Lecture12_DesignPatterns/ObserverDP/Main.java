package Lecture11_DesignPatterns.ObserverDP;

public class Main {
    public static void main(String[] args) {
        DataSource s = new DataSource(5);
        BarGraph g = new BarGraph(s);
        ExcelTable t = new ExcelTable(s);
        //Registering the observers on the data source
        s.addObserver(g);
        s.addObserver(t);

        //change the data sources
        s.setValue(10);

    }
}
