package javastrams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String []args){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, IntSummaryStatistics> result = nums.stream()
                .collect(Collectors.groupingBy(
                        n->n%2==0,
                        Collectors.summarizingInt(Integer::intValue)
                ));

        System.out.println(result);

        List<String> words = Arrays.asList(
                "cat", "dog", "cow", "ant", "bee", "fox"
        );

        Map<String, Long> result2 = words.stream()
                .collect(Collectors.groupingBy(
                        s->s+s.length(),
                        Collectors.counting()
                ));
        System.out.println(result2);

        List<String> names = Arrays.asList(
                "Alice", "Bob", "Charlie", "Anna", "Brian", "Catherine"
        );

        Map<Character, List<String>> result3 = names.stream()
                .collect(Collectors.groupingBy(
                        name -> name.charAt(0)
                ));

        result3.forEach((k, v) -> System.out.println(k + " -> " + v));


        List<String> words3 = Arrays.asList(
                "apple", "banana", "avocado", "blueberry", "cherry", "apricot"
        );

        Map<Character, Optional<String>> result4 = words3.stream()
                .collect(Collectors.groupingBy(
                        w -> w.charAt(0),
                        Collectors.maxBy(Comparator.comparingInt(String::length))
                ));

        result4.forEach((k, v) ->
                System.out.println(k + " -> " + v.get()));

        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<String, List<Integer>> result5 = nums1.stream()
                .collect(Collectors.groupingBy(n -> {
                    if      (n <= 3) return "low";
                    else if (n <= 6) return "medium";
                    else             return "high";
                }));

        result5.forEach((k, v) -> System.out.println(k + " -> " + v));


        List<String> words6 = Arrays.asList(
                "ant", "ape", "bat", "bee", "cat", "cow","apple"
        );

        Map<Character, Map<Integer, List<String>>> result6= words6.stream()
                .collect(Collectors.groupingBy(
                        w -> w.charAt(0),
                        Collectors.groupingBy(String::length)
                ));

        result6.forEach((letter, map) ->
                map.forEach((len, list) ->
                        System.out.println(letter + ", len=" + len + " -> " + list)
                )
        );

        List<Integer> nums11 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        Map<Boolean, List<Integer>> primes11 = nums11.stream()
                .collect(Collectors.partitioningBy(
                        StreamUsage::isPrime
                ));


        List<String> words1 = Arrays.asList("apple", "banana", "cherry");

        Map<String, Integer> result11 = words1.stream()
                .collect(Collectors.toMap(
                        w -> w,           // key   = word itself
                        String::length    // value = length of word
                ));

        System.out.println(result11);


        List<String> words8 = Arrays.asList(
                "apple", "avocado", "banana", "blueberry"
        );

        // merge function handles duplicate keys
        Map<Character, String> result12 = words8.stream()
                .collect(Collectors.toMap(
                        w -> w.charAt(0),          // key = first letter
                        w -> w,                    // value = word
                        (existing, newVal) -> existing + ", " + newVal  // merge
                ));

        result12.forEach((k, v) -> System.out.println(k + " -> " + v));

        List<Integer> nums13 = Arrays.asList(10, 20, 30, 40, 50);

        IntSummaryStatistics stats = nums13.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum:   " + stats.getSum());
        System.out.println("Min:   " + stats.getMin());
        System.out.println("Max:   " + stats.getMax());
        System.out.println("Avg:   " + stats.getAverage());

        List<String> words11 = Arrays.asList("Java", "is", "awesome");

        String resu = words11.stream()
                .reduce("", (a, b) -> a + (a.isEmpty() ? "" : " ") + b);

        System.out.println(resu);
        System.out.println(resu.length());

        names = Arrays.asList("Alice", "Bob", "Charlie");

        String r1 = names.stream()
                .collect(Collectors.joining());

        String r2 = names.stream()
                .collect(Collectors.joining(", "));

        String r3 = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        words = Arrays.asList(
                "banana", "apple", "cherry","vavava", "date", "elderberry"
        );

        List<String> result23 = words.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());

        System.out.println(result23);

        //todo averagingInt

        //Map<String, Double> avgSalaryByDept = employees.stream()
        //            .collect(Collectors.groupingBy(
        //                e -> e.dept,
        //                Collectors.averagingInt(e -> e.salary)
        //            ));

    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
