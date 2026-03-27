package two_pointers;

import java.util.HashMap;
import java.util.Map;

class TwoPointersArray {
    public static void main(String[] args) {
        //checked for sorted and unsorted array
        int arr[] = new int[]{11,2,15,7};
        int target = 9;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if ((arr[left] + arr[right]) > target) {
                if (arr[left] < arr[right]) {
                    right--;
                } else {
                    left++;
                }
            }else if((arr[left] + arr[right]) < target){
                if( arr[left] < arr[right]){
                    left++;
                }else{
                    right--;
                }
            }else if((arr[left] + arr[right]) == target){
                break;
            }else{
                left++;
                right--;
            }
        }
        System.out.println("left:"+left + " right:"+right);
    }
}

class AiApproarch{
    // Two sum in array works only if its sorted.
    public static void main(String [] args){
        int arr[] = new int[]{2,5,7,9};
        int target = 9;
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int sum=arr[left]+arr[right];
            if(sum==target) break;
            if(sum > target){
                right--;
            }else {
                left++;
            }
        }
        System.out.println("left:"+left + " right:"+right);
    }
}

class UnsortedArray{
    public static void main(String [] args){
        int arr[] = new int[]{2,7,5,9};
        int target = 9;
        int left = 0;
        int right = arr.length - 1;

        Map<String,String> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int current=target-arr[i];
            if(map.containsKey(String.valueOf(current))){
                System.out.println("index first:"+i +" And index second"+map.get(String.valueOf(current)));
            }
            map.put(String.valueOf(arr[i]),String.valueOf(i));
        }
        System.out.println("Nothing found..");
    }
}

class PalindromeString{
    public static void main(String []a){
        String str="abmdmba";
        int left=0;
        int right=str.length()-1;
        boolean flag=true;

        while(left < right){
            if(str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }else{
                flag=false;break;
            }
        }

        System.out.println("Palindrome.."+flag);

    }

}

class MaxWater{
    public static void main(String [] args){
        int[] heights =new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int left=0;
        int right=heights.length-1;
        int maxWater=0;
        int[] index =new int[2];
        while(left<right){
            int width=right-left;
            int small=Math.min(heights[left],heights[right]);
            int capacity=small * width;
            if(maxWater<capacity){
                maxWater=capacity;
                index[0]=left;
                index[1]=right;
            }
            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        System.out.println("MaxWater:"+maxWater+ "id1 :"+index[0] +" id2:"+index[1]);

    }
}