package dynamicprogramming;

public class MinimumCostToClimbingStares {
//    ### Problem 2 — Min Cost Climbing Stairs (LeetCode #746)
//
//**Question:** Each step has a cost. You can climb 1 or 2 steps. Find minimum cost to reach the top.
//    cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//
//    dp[0] = 1
//    dp[1] = 100
//    dp[2] = 1  + min(100, 1)   = 2
//    dp[3] = 1  + min(2,  100)  = 3
//    dp[4] = 1  + min(3,  2)    = 3
//    dp[5] = 100+ min(3,  3)    = 103
//    dp[6] = 1  + min(103,3)    = 4
//    dp[7] = 1  + min(4,  103)  = 5
//    dp[8] = 100+ min(5,  4)    = 104
//    dp[9] = 1  + min(104,5)    = 6
//    Answer = min(dp[9], dp[8]) = min(6, 104) = 6 ✅


    public static void main(String args[]){
          int []cost = new int []{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
          int dp[]=new int[cost.length];
          dp[0]=1;
          dp[1]=100;
          for(int i=2;i<cost.length;i++){
              dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
          }

          System.out.println(Math.min(dp[cost.length-1],dp[cost.length-2]));

    }
}
