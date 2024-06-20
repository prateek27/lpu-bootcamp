package Lecture08_Generics;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(10);
        s1.push(20);
        s1.push(30);

        System.out.println(s1);
        Stack<String> s2 = new Stack<>();
        s2.push("Heloo");
        s2.push("World");
        s2.pop();

        System.out.println(s2);


    }
}
