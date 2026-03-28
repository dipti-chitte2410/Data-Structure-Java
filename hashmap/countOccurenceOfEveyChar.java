package hashmap;

import java.util.HashMap;
import java.util.Map;

public class countOccurenceOfEveyChar {
    public static void main(String [] args){
        int arr[] = new int[]{1,3,4,5,2,4,5};
        Map<Integer,Integer> map=new HashMap<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}

class Storingindex{
    public static void main(String[] args){
        int arr[] = new int[]{1,3,4,5,2,4,5};
        HashMap<Integer,Integer> hashmap=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hashmap.put(arr[i],i);
        }
        System.out.println(hashmap.get(5));
    }
}


class FindComplementExistInTwoSum{
    public static void main(String [] args){
        int arr[] = new int[]{2,5,7,9};
        int target = 9;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                System.out.println("Pair exist.."+i+"  "+map.get(target-arr[i]));
            }
            map.put(arr[i],i);
        }
    }
}