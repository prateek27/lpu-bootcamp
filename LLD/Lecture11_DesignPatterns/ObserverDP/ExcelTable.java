package Lecture11_DesignPatterns.ObserverDP;

public class ExcelTable implements Observer{
    private DataSource dataSource;

    public ExcelTable(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void update(){
        System.out.println("Excel table got updated!");
    }

    @Override
    public String toString() {
        return "ExcelTable{" +
                "dataSource=" + dataSource +
                '}';
    }
}
