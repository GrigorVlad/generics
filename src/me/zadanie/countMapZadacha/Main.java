package me.zadanie.countMapZadacha;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CountMap<Integer> map = new MyCountMap<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        map.print();
        System.out.println();

        CountMap<Integer> newMap = new MyCountMap<>();

        for (int i = 0; i < 5; i++) {
            newMap.add(3);
            newMap.add(5);
            newMap.add(8);
        }

        map.addAll(newMap);

        map.print();
        System.out.println("*******************************************************************");

        Map<Integer, Integer> finalMap = new HashMap<>();
        finalMap.put (3, 2);
        finalMap.put(15, 82);
        finalMap.put(100, 96);

        for (Map.Entry<Integer, Integer> pair : finalMap.entrySet()) {
            System.out.println(pair.getKey() + "___" + pair.getValue());
        }
        System.out.println("*******************************************************************");

        map.toMap(finalMap);
        for (Map.Entry<Integer, Integer> pair : finalMap.entrySet()) {
            System.out.println(pair.getKey() + "___" + pair.getValue());
        }



    }
}
