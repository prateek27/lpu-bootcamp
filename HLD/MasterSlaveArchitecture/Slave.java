package Lecture12_HLD.MasterSlaveArchitecture;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Slave{
    private Master master;
    private ScheduledExecutorService executorService;


    public Slave(Master master){
        this.master = master;
        executorService = Executors.newScheduledThreadPool(1);
    }

    public void startSync(){
        executorService.scheduleAtFixedRate(this::syncWithMaster,0,5, TimeUnit.SECONDS);
    }

    private void syncWithMaster(){
        List<String> updates = master.getUpdatesSinceLastSync();
        for(String u:updates){
            //process that update in slave database
            System.out.println("Processing " + u);
        }
    }

    public void stop(){
        executorService.shutdown();
    }
}
