package sliding_window;

public class MaximumSumArray {

//    arr = [2, 1, 5, 1, 3, 2],  K = 3
//
//    All subarrays of size 3:
//            [2, 1, 5] → sum = 8
//            [1, 5, 1] → sum = 7
//            [5, 1, 3] → sum = 9  ← maximum
//            [1, 3, 2] → sum = 6

    public static void main(String []args){
        int []arr = new int[] {2, 1, 5, 1, 3, 2};
        int K = 3;
        int result=0;
        int left=0;
        int sum=0;

        for(int right=0;right<arr.length;right++){
            sum=arr[right]+sum;
            if(right-left+1 > K){
                sum=sum-arr[left];
                left++;
            }
            if(right-left+1 == K){
                result=Math.max(sum,result);
            }
        }
        System.out.println(result);


    }
}
