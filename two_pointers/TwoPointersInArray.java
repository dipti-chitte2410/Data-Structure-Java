package two_pointers;
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