package dynamicprogramming;

public class HouseRobber {

//
//### Problem 2 — House Robber (LeetCode #198)
//
//**Question:** Houses in a row have money. You cannot rob two adjacent houses. Find max money you can rob.
//            ```
//    houses = [2, 7, 9, 3, 1]
//
//    Option 1: rob house 0,2,4 → 2+9+1 = 12
//    Option 2: rob house 1,3   → 7+3   = 10
//    Option 3: rob house 0,2   → 2+9   = 11
//    Option 4: rob house 1,4   → 7+1   = 8
//
//    Answer: 12
//            ```
//
//            **Think like this:**
//            ```
//    At each house you have TWO choices:
//  1. Rob this house + best from 2 houses ago  (skip neighbour)
//  2. Skip this house + best from previous house
//
//    dp[i] = max(
//            houses[i] + dp[i-2],   // rob current + skip neighbour
//            dp[i-1]                // skip current
//    )
//```
//
//        **Build bottom up:**
//            ```
//    houses = [2, 7, 9, 3, 1]
//
//    dp[0] = 2          (only one house → rob it)
//    dp[1] = max(2,7)=7 (two houses → rob the bigger one)
//    dp[2] = max(9+dp[0], dp[1]) = max(9+2, 7) = max(11,7) = 11
//    dp[3] = max(3+dp[1], dp[2]) = max(3+7, 11) = max(10,11) = 11
//    dp[4] = max(1+dp[2], dp[3]) = max(1+11, 11) = max(12,11) = 12
//
//    Answer: 12 ✅

    public static void main(String [] args) {
        int[] houses = new int[]{2, 7, 9, 3, 1};
        int [] dp=new int[houses.length+1];
        dp[0]=houses[0];
        dp[1]=Math.max(houses[1],houses[0]);
        for(int i=2;i<houses.length;i++){
            dp[i]=Math.max(houses[i]+dp[i-2],dp[i-1]);
        }
        System.out.println(dp[houses.length-1]);
    }
}
