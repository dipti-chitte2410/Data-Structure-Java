package hashmap;

import java.util.HashMap;

public class KMostFrequentElement {
    public static void main(String [] args){
        int [] arr = new int[] {1, 1, 1, 2, 2, 3};
        int K = 2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int ar[]=map.entrySet().stream().
                sorted((a,b)->b.getValue()-a.getValue())
                        .limit(2)
                                .mapToInt(m->m.getKey())
                                        .toArray();
        System.out.println(ar[0]
                +" " +ar[1]);
    }
}
