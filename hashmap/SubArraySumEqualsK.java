package hashmap;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String [] args){
        int [] arr =new int[] {1, 5, 2,3,2,1,1,4};
        int K = 7;
        int sum=0;
        int count=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i:arr){
            sum=sum+i;
            if(map.containsKey(sum-K)){
                count=count+map.get(sum-K);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println(count);
    }
}

