package Lecture12_HLD.MasterSlaveArchitecture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Master {
    private List<String> state;
    private ReentrantLock lock = new ReentrantLock();
    int lastReadIdx;
    Master(){
        state = new ArrayList<>();
        lastReadIdx = 0;
    }
    public void addData(String data){
        lock.lock();
        System.out.println("Adding data " + data);
        state.add(data);
        lock.unlock();
    }
    public List<String> getUpdatesSinceLastSync(){
        lock.lock();
        try{
            List<String> updates = state.subList(lastReadIdx,state.size());
            lastReadIdx = state.size();
            return new ArrayList<>(updates);
        }
        finally {
            lock.unlock();
        }
    }

}
