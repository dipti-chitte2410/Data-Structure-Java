package hashmap;

import java.util.*;

public class GroupAnangram {
    public static void main(String[] args){
        String [] Input=new String []  {"eat","tea","tan","ate","nat","bat"};
        HashMap<String, List<String>> map=new HashMap<>();
        for(String str:Input){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String sorted =new String(chars);

            map.putIfAbsent(sorted,new ArrayList<>());
            map.get(sorted).add(str);
        }
        System.out.println(new ArrayList<>(map.values()));
    }
}
