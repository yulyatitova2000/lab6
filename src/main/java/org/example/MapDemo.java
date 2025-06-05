package org.example;

import java.util.*;

public class MapDemo {
    public static Set<Human> getHumanSet(Map<Integer, Human> humanMap, Set<Integer> integerSet) {
        Set<Human> result = new LinkedHashSet<>();
        for (int key : integerSet) {
            Human temp = humanMap.get(key);
            if (temp != null) {
                result.add(temp);
            }
        }
        return result;
    }

    public static List<Integer> getHumanListForAge(Map<Integer, Human> humanMap) {
        List<Integer> result = new ArrayList<>();
        for (int key : humanMap.keySet()) {
            if (humanMap.get(key).getAge() >= 18) {
                result.add(key);
            }
        }
        return result;
    }

    public static Map<Integer, Integer> getHumanMapForIdAge(Map<Integer, Human> humanMap) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int key : humanMap.keySet()) {
            Human temp = humanMap.get(key);
            result.put(key, temp.getAge());
        }
        return result;
    }

    public static Map<Integer, List<Human>> getMapListHuman(Set<Human> humanSet) {
        Map<Integer, List<Human>> result = new HashMap<>();
        for (Human human : humanSet) {
            List<Human> list = result.get(human.getAge());
            if (list != null) {
                list.add(human);
            } else {
                list = new ArrayList<>();
                list.add(human);
                result.put(human.getAge(), list);
            }
        }
        return result;
    }
    public static TreeSet<Human> getSortedStudent(Set<Human> humanSet){
        TreeSet<Human> treeSet = new TreeSet<>(new FIOComparator());
        treeSet.addAll(humanSet);
        return treeSet;

    }

}
