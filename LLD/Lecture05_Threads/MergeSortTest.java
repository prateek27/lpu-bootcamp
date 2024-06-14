package Lecture05_Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSortTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arr = new ArrayList<>(List.of(10,20,4,1,3,6,9));
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<List<Integer>> output = executor.submit(new MergeSort(arr,executor));

        System.out.println(output.get());
    }
}
