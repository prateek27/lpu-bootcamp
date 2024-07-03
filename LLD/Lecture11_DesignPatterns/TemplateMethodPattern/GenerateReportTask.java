package Lecture11_DesignPatterns.TemplateMethodPattern;

public class GenerateReportTask extends Task{

    @Override
    protected void perform(){
        //business logic
        System.out.println("Generating a report");
    }
}
