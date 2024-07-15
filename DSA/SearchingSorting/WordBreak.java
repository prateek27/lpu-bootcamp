package CompetitiveProgramming.SearchingSorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {


    public static boolean canPartition(String s,Set<String> dictSet,HashMap<String,Boolean> dp){
        //base case
        if(s.isEmpty()){
            return true;
        }
        // if the key is present in the hashmap
        if(dp.containsKey(s)){
            return true;
        }

        //try to make a cut at every place
        int n = s.length();
        for(int i=1;i<=n;i++){
            String token = s.substring(0,i);
            String remaining = s.substring(i);
            if(dictSet.contains(token) && canPartition(remaining,dictSet,dp)){
                dp.put(s,true);
                return true;
            }
        }
        return false;
    }

    //Bottom Up
    public static boolean canPartitionBottomUp(String s,Set<String> dictSet){
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        //O(N^2)
        for(int n=1;n<=s.length();n++){
            //partition length
            for(int len=0;len<n;len++){
                String remainingToken = s.substring(len,n);
                if(dp[len]==true && dictSet.contains(remainingToken)){
                    dp[n] = true;
                    break;
                }
            }
        }
        //print the dp array
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }


    public static void main(String[] args) {
        String dict[] = {"apple"};
        Set<String> dictSet = new HashSet();
        HashMap<String, Boolean> dp = new HashMap<>();

        //Set for fast looksup
        for(String word:dict){
            dictSet.add(word);
        }
        String s = "appleapple";

        System.out.println(canPartition(s,dictSet,dp));
        System.out.println(canPartitionBottomUp(s,dictSet));
    }
}
