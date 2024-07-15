package CompetitiveProgramming.SearchingSorting.LadderProblem;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    static void printAllSubsets(List<Integer> arr,int targetSum,int start,List<Integer> currentSet){
        //base case
        if(start==arr.size()){
            if(targetSum==0){
                System.out.println(currentSet);
                return;
            }
            return;
        }

        //rec case
        //take the element
        currentSet.add(arr.get(start));
        printAllSubsets(arr,targetSum - arr.get(start),start+1,currentSet);
        //backtrack
        currentSet.remove(arr.get(start));

        //don't take the element
        printAllSubsets(arr,targetSum,start+1,currentSet);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(3,5,2,1,8,-1));
        int targetSum = 10;
        printAllSubsets(arr,targetSum,0, new ArrayList<>());
    }
}
