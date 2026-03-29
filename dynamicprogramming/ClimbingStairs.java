package dynamicprogramming;

public class ClimbingStairs {
//**Question:** You can climb 1 or 2 steps at a time. How many ways to reach step N?
//        Answer: 5
//            ```
//
//            **Think like this:**
//            ```
//    To reach step 4 → you came from step 3 (took 1 step)
//    OR you came from step 2 (took 2 steps)
//
//    ways(4) = ways(3) + ways(2)
//    ways(3) = ways(2) + ways(1)
//    ways(2) = ways(1) + ways(0)
//    ways(1) = 1   ← base case (only one way — take 1 step)
//    ways(0) = 1   ← base case (you are already there)
//
//    Build bottom up:
//    dp[0] = 1
//    dp[1] = 1
//    dp[2] = dp[1] + dp[0] = 2
//    dp[3] = dp[2] + dp[1] = 3
//    dp[4] = dp[3] + dp[2] = 5  ✅

    public static void main(String [] args){
        int[] dp =new int[4+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[4]);
    }
}
