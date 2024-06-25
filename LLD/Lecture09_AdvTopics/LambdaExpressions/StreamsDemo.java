package Lecture09_AdvTopics.LambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        // Birds
        ArrayList<String> birds
                = new ArrayList<>(List.of("Sparrow","Snake Bird","Bulbul","Serpent Eagle","Myna","Sunbird"));

        // Filter birds whose name start with S
        // and convert these birds into name like "Bird Sparrow"
        // return a new list
        // .. "Bird Sparrow" , "Bird Snake Bird", "Bird Serpent Eagle"..


        //Declarative Programming
        ArrayList<String> output = new ArrayList<>();
        for(String bird:birds){
            if(bird.startsWith("S")){
                output.add("Bird "+bird);
            }
        }
        System.out.println(output);

        //Functional Programming
        birds.stream()
                .filter(bird->bird.startsWith("S"))
                .map(bird->"Bird "+bird)
                .forEach(System.out::println);



        //Given a list of integers
        // filter the even numbers
        // and square them up
        //1. print the result
        // 2. find the sum of squares

        List<Integer> l = List.of(1,2,4,4,5,6,9,10,11);

        long ans = l.stream()
                .filter(n->n%2==0)
                .distinct()
                .map(n->n*n)
                .count();

        l.stream()
                .filter(n->n%2==0)
                .distinct()
                .map(n->n*n)
                .forEach(n->System.out.println(n));

        int sum = l.stream()
                .filter(n->n%2==0)
                .distinct()
                .map(n->n*n)
                .reduce(0,(a,b)->a+b);

        System.out.println(sum);
        System.out.println(ans);







    }
}
