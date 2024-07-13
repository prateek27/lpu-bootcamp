package CompetitiveProgramming.Hashmap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>(5);
        map.insert("Dosa",100);
        map.insert("Idly",20);
        map.insert("Coke",105);
        map.insert("Soda",50);
        map.insert("IceTea",150);

        System.out.println(map.search("Coke"));
        System.out.println(map.search("IceTea"));
        //HomeWork - Erase Functionality

    }
}
