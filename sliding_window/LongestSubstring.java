package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

//              s = "abcabcbb"
//
//            "abc"     → length 3, no repeats ✅
//            "abca"    → 'a' repeats ❌ → shrink from left
//            "bca"     → length 3, no repeats ✅
//            "bcab"    → 'b' repeats ❌ → shrink
//...

    public static void main(String [] args){
       String s = "abcabcbb";
       String unique="";
       int length=0;
       int left=0;
       Set<String> set=new HashSet();
       for(int right=0;right<s.length();right++) {
           if(set.contains(s.charAt(right)+"")){
               set.remove(s.charAt(left)+"");
               left++;
           }
           set.add(s.charAt(right)+"");

           //length=Math.max(set.size(),length);
           //or
           length=Math.max(set.size(),right-left+1);

       }

       System.out.println(length);
    }
}
