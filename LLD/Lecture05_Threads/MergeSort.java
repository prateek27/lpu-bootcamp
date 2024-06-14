package Lecture05_Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {
    List<Integer> arr;
    ExecutorService executor;

    MergeSort(List<Integer> arr, ExecutorService executor){
        this.arr = arr;
        this.executor = executor;
    }

    @Override
    public List<Integer> call() throws Exception {
        //base case
        if(arr.size()<=1){
            return arr;
        }

        //rec case
        int mid = arr.size()/2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        //left
        for(int i=0;i<mid;i++){
            left.add(arr.get(i));
        }

        //right
        for(int i=mid;i<arr.size();i++){
            right.add(arr.get(i));
        }
        //Sort Left and Right Half Recursively
        Future<List<Integer>> leftSortedFuture = executor.submit(new MergeSort(left,executor));
        Future<List<Integer>> rightSortedFuture = executor.submit(new MergeSort(right,executor));

        // Merge
        left = leftSortedFuture.get();
        right = rightSortedFuture.get();

        List<Integer> output = new ArrayList<>();
        int i=0,j=0;
        while(i<left.size() && j<right.size()){
            if(left.get(i) < right.get(j)){
                output.add(left.get(i));
                i++;
            }
            else{
                output.add(right.get(j));
                j++;
            }
        }
        while(i<left.size()){
            output.add(left.get(i));
            i++;
        }
        while(j<right.size()){
            output.add(right.get(j));
            j++;
        }
        System.out.println(Thread.currentThread().getName() + output);
        return output;
    }
}
