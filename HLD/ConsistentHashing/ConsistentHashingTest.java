package Lecture12_HLD;

public class ConsistentHashingTest {
    public static void main(String[] args) {
        ConsistentHashing ch = new ConsistentHashing(3);
        ch.addMachine("Machine1");
        ch.addMachine("Machine2");
        ch.addMachine("Machine3");

        for(int i=1;i<=1000;i++){
            System.out.println("Mapping user to "+ch.distribute("U"+i*57));;
        }
        ch.removeMachine("Machine1");
        ch.addMachine("Machine4");
        for(int i=1;i<=1000;i++){
            System.out.println("Getting user from "+ch.distribute("U"+i*57));;
        }
    }
}
