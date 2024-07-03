package Lecture11_DesignPatterns.TemplateMethodPattern;

public abstract class Task {
    protected AuditTrail auditTrail;

    public Task(){
        auditTrail = new AuditTrail();
    }

    public void start(){
        auditTrail.record();
        perform();
    }
    protected abstract void perform();
}
