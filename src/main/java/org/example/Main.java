package org.example;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //create  list of employee
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Naman", 10000, "New York"));
        employees.add(new Employee(2, "Ali", 20000, "New York"));
        employees.add(new Employee(3, "Zainab", 30000, "New York"));
        employees.add(new Employee(4, "Ali", 40000, "New York"));
        employees.add(new Employee(5, "Zainab", 50000, "New York"));
        employees.add(new Employee(6, "Ali", 60000, "New York"));

        //sort on the basis of salary
        Comparator<Employee> sortBasedOnSalary = Comparator.comparing(Employee::getSalary).reversed();
       Collections.sort(employees,sortBasedOnSalary);
        System.out.println(employees);
        System.out.println("-------------------------------------------------");

       Comparator<Employee> bySalary = (Employee e1, Employee e2) -> {
           return (int) (e2.getSalary()-e1.getSalary());
        };
       Collections.sort(employees, bySalary);
       System.out.println(employees);

        //group the employee based on name
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getName));
        collect.forEach((key,value)->{
            System.out.println("Name:"+key+"  "+" List of employee:"+value);
        });

        System.out.println("-------------------------------------------------");

        employees.stream().mapToDouble(Employee::getSalary).average().ifPresent(System.out::println);

        System.out.println("-------------------------------------------------");

        employees.stream().filter(e->e.getSalary()==30000).peek(e->e.setCity("USA")).forEach(System.out::println);
        System.out.println(employees);

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
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("one", 1);
        map1.put("two", 2);
        map1.put("three", 3);
        map1.put("four", 4);
        map1.put("five", 5);

        Map<String,Integer> newMap=new HashMap<>();

        for(Map.Entry<String,Integer> entry:map1.entrySet()){
            String key=entry.getKey();
            if(map.containsKey(key)){
                newMap.put(key,entry.getValue()+map.get(key));
            }else{
                newMap.put(key,entry.getValue());
            }

        }
        for(Map.Entry<String,Integer> entry:newMap.entrySet()){
        System.out.println(entry.getKey()+" "+entry.getValue());
        }

        System.out.println("hello ji");
        //use foreach loop to iterate map1
        map1.forEach((key,value)->{
            System.out.println("key :"+ key + " value: " + value);
        });

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

        //List of Map of Map
      //  List<Map<String, Integer>> listOfMap = Arrays.asList(map, map1);


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

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        list1.stream().mapToInt(Integer::intValue).min().ifPresent(System.out::println);
        list1.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
        list1.stream().mapToInt(Integer::intValue).average().ifPresent(System.out::println);
        int sum = list1.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);
        //sort the list1
        Optional<Integer> first = list1.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst();
        first.ifPresent(System.out::println);

//------------------------------------Fail-Safe iterator----------------------------------------------------
        List<String> copyList = new CopyOnWriteArrayList<>(Arrays.asList("A", "B", "C"));
        for(String s:copyList){
            copyList.add("D");
        }
        System.out.println(copyList);

        System.out.println("Go Ahead");

 //--------------------------------------Fail-Fast iterator------------------------------------------
        List<Integer> lists = Arrays.asList(1,2,3);
        for(Integer list9:lists) {
            System.out.println(list9);
            lists.add(4);
        }
        System.out.println(lists);
    }

    }
