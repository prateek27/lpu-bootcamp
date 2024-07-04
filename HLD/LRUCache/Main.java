package Lecture12_HLD.LRUCache;

public class Main {
    public static void main(String[] args) {
       Storage s = new ObjectStorage();
       s.write("TC1","1 2 3 4 5");
       s.write("TC2","11 12 3 4 5");
       s.write("TC3","14 23 3 4 5");
       s.write("TC4","14 23 3 4 5");
        s.write("TC5","14 23 3 4 5");


        ProblemService ps = new ProblemService(3,s);
        System.out.println(ps.getTestCase("TC1"));

        System.out.println(ps.getTestCase("TC2"));
        System.out.println(ps.getTestCase("TC3"));
        System.out.println(ps.getTestCase("TC4"));
        System.out.println(ps.getTestCase("TC5"));

        System.out.println(s);

    }


}
