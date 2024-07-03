package Lecture12_HLD;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

    int numberOfPlaces;
    private List<String> machines;
    private SortedMap<Integer,String> circle;

    ConsistentHashing(int numberOfPlaces){
        this.numberOfPlaces = numberOfPlaces;
        machines = new ArrayList<>();
        circle = new TreeMap<>();
    }

    public void addMachine(String machineId){
        machines.add(machineId);
        for(int i=0;i<numberOfPlaces;i++){
            int machineHash = hash(machineId + "_"+i);
            circle.put(machineHash,machineId);
        }

    }
    public void removeMachine(String machineId){
        machines.remove(machineId);

        for(int i=0;i<numberOfPlaces;i++){
            int machineHash = hash(machineId + "_"+i);
            circle.remove(machineHash);
        }
    }

    public String distribute(String userId){
        // empty case
        if(circle.isEmpty()){
            return null;
        }
        //normal case
        int userHash = hash(userId);
        SortedMap<Integer,String> tailMap = circle.tailMap(userHash);

        if(tailMap.isEmpty()){
            return circle.get(circle.firstKey());
        }
        else{
            return circle.get(tailMap.firstKey());
        }
    }

    public String get(String userId){
        return distribute(userId);
    }

    private int hash(String s){
        return s.hashCode()%29;
    }
}
