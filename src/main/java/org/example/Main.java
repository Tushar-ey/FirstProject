package org.example;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Integer reduce = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        List<String> listNames = Arrays.asList("Naman", "Ali", "Zainab", "Ali");
        // count the repetative words in list
        Map<String, Integer> nameFrequencyMap = new HashMap<>();

        for (String name : listNames) {
            nameFrequencyMap.put(name, nameFrequencyMap.getOrDefault(name, 0) + 1);
        }
        System.out.println(nameFrequencyMap);
//-------------------filter even number------------------------------------------------------
        list.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

//----------------------if same key in two maps then add their values and stored in new map----------------------------------
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("one", 1);
        map1.put("two", 2);
        map1.put("three", 3);
        map1.put("four", 4);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map<String, Integer> resultedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            resultedMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (resultedMap.containsKey(key)) {
                resultedMap.put(key, value + resultedMap.get(key));
            } else {
                resultedMap.put(key, value);
            }
        }
        System.out.println(resultedMap);

        System.out.println("-------------------------------------------------");
        System.out.println("===============================================");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

//       for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            if (map1.containsKey(key)) {
//                map.put(key, value + map1.get(key));
//            } else {
//                map.put(key, value);
//            }
//        }
//        System.out.println(map);
//       }
        }
    }
