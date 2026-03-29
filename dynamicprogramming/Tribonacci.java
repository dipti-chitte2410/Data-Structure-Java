package dynamicprogramming;

public class Tribonacci {

//    ### Problem 3 — Tribonacci (LeetCode #1137)
//
//**Question:** Like Fibonacci but each number = sum of previous THREE numbers.
//```
//    T(0) = 0
//    T(1) = 1
//    T(2) = 1
//    T(3) = 0+1+1 = 2
//    T(4) = 1+1+2 = 4
//    T(5) = 1+2+4 = 7

    public static void main(String [] args){
        int k=6;
        int dp[]=new int[k+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<k;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        System.out.println(dp[k-1]);
    }
}
