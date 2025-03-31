package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MapDemoTest {

    @Test
    void getHumanSet() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("Иван", "Иванов", "Иванович", 34));
        humanMap.put(3, new Human("Влад", "Смирнов", "Иванович", 24));
        humanMap.put(2, new Human("Иван", "Чирков", "Иванович", 45));

        Set<Integer> integerSet = new LinkedHashSet<>();
        integerSet.add(7);
        integerSet.add(22);
        integerSet.add(42);
        integerSet.add(2);
        integerSet.add(34);
        Set<Human> humanSet = MapDemo.getHumanSet(humanMap, integerSet);
        Set<Human> result = new LinkedHashSet<>();
        result.add(humanMap.get(2));
        assertEquals(humanSet, result);



    }

    @Test
    void getHumanListForAge() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("Иван", "Иванов", "Иванович", 34));
        humanMap.put(3, new Human("Влад", "Смирнов", "Иванович", 12));
        humanMap.put(2, new Human("Иван", "Чирков", "Иванович", 45));

        List<Integer> integerList = MapDemo.getHumanListForAge(humanMap);
        assertEquals(2, integerList.size());
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        assertEquals(integerList, result);
    }

    @Test
    void getHumanMapForIdAde() {
        Map<Integer, Human> humanMap = new HashMap<>();
        humanMap.put(1, new Human("Иван", "Иванов", "Иванович", 34));
        humanMap.put(2, new Human("Влад", "Смирнов", "Иванович", 12));
        humanMap.put(3, new Human("Иван", "Чирков", "Иванович", 45));

        Map<Integer, Integer> integerMap = MapDemo.getHumanMapForIdAge(humanMap);
        Map<Integer, Integer> resultMap = new HashMap<>();
        resultMap.put(1, 34);
        resultMap.put(2, 12);
        resultMap.put(3, 45);
        assertEquals(resultMap, integerMap);
    }

    @Test
    void getMapListHuman() {
        Set<Human> humanSet = new LinkedHashSet<>();
        humanSet.add(new Human("Иван", "Иванов", "Иванович", 10));
        humanSet.add(new Human("Влад", "Смирнов", "Иванович", 10));
        humanSet.add(new Human("Иван", "Чирков", "Иванович", 20));
        humanSet.add(new Human("Иван", "Петров", "Иванович", 20));
        humanSet.add(new Human("Иван", "Смирнов", "Иванович", 30));

        Map<Integer, List<Human>> integerListMap = MapDemo.getMapListHuman(humanSet);
        assertEquals(2, integerListMap.get(10).size());
        assertEquals(2, integerListMap.get(20).size());
        assertEquals(1, integerListMap.get(30).size());
        List<Human> humanList1 = new ArrayList<>();
        humanList1.add(0, new Human("Иван", "Иванов", "Иванович", 10));
        humanList1.add(1, new Human("Влад", "Смирнов", "Иванович", 10));
        List<Human> humanList2 = new ArrayList<>();
        humanList2.add(0, new Human("Иван", "Чирков", "Иванович", 20));
        humanList2.add(1, new Human("Иван", "Петров", "Иванович", 20));
        List<Human> humanList3 = new ArrayList<>();
        humanList3.add(0, new Human("Иван", "Смирнов", "Иванович", 30));

        Map<Integer, List<Human>> result = new LinkedHashMap<>();
        result.put(10, humanList1);
        result.put(20,humanList2);
        result.put(30, humanList3);
        assertEquals(integerListMap, result);





    }
}