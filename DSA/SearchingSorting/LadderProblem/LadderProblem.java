package CompetitiveProgramming.SearchingSorting.LadderProblem;

import java.util.ArrayList;
import java.util.List;

public class LadderProblem {

    static int computeSteps(int N,int K){
        if(N==0){
            return 1;
        }
        else if(N<0){
            return 0;
        }
        int ans = 0;
        for(int t=1;t<=K;t++){
            ans += computeSteps(N-t,K);
        }
        return ans;
    }
    static void printSteps(int N, int K, List<Integer> currentPath,List<List<Integer>> allPaths){
        if(N==0){
            System.out.println(currentPath);
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }
        else if(N<0){
            return;
        }
        for(int t=1;t<=K;t++){
            int currentStep = N;
            int goingStep = N - t;
            int jumpSize = currentStep - goingStep;
            currentPath.add(jumpSize);
            printSteps(N-t,K,currentPath,allPaths);
            //Pop (Backtracking Step)
            currentPath.remove(currentPath.size()-1);
        }
    }

    static int computeStepsTopDownDP(int N,int K,int[] dp){
        if(N==0){
            return 1;
        }
        else if(N<0){
            return 0;
        }
        //Memoisation Step (return ans if already computed)
        if(dp[N]!=0){
            return dp[N];
        }
        int ans = 0;
        for(int t=1;t<=K;t++){
            ans += computeStepsTopDownDP(N-t,K,dp);
        }
        //compute and store ans
        dp[N] = ans;
        return ans;
    }

    static int computeStepsBottomUpDP(int N,int K){
        int dp[] = new int[N+1];
        dp[0] = dp[1] = 1;

        //O(N*K)
        for(int n=2;n<=N;n++){
            int ans = 0;
            for(int k=1;k<=K;k++){
                if(n-k>=0){
                    ans += dp[n-k];
                }
            }
            dp[n] = ans;
        }
        return dp[N];
    }
    public static void main(String[] args) {
        System.out.println(computeSteps(4,3));
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();

        printSteps(4,3,currentPath,allPaths);
        System.out.println(allPaths);

        //Top Down DP
        int dp[] = new int[5];
        System.out.println(computeStepsTopDownDP(4,3,dp));
        System.out.println(computeStepsBottomUpDP(4,3));


    }
}
