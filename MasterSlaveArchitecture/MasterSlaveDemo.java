package Lecture12_HLD.MasterSlaveArchitecture;

public class MasterSlaveDemo {
    public static void main(String[] args) throws InterruptedException {
        Master master = new Master();
        Slave slave = new Slave(master);

        Thread masterThread = new Thread(()->{
           for(int i=0;i<=20;i++){
               master.addData("Update " + i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });


        masterThread.start();
        slave.startSync();

        masterThread.join();
        slave.stop();
    }
}
