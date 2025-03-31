package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDemo {
    public static List<Human> getByLastName(List<Human> humanList, Human human){
        List<Human> result = new ArrayList<>();
        for (Human human1 : humanList) {
            if (human1.getLastName().equals(human.getLastName())) {
                result.add(human1);
            }
        }
        return result;
    }

    public static ArrayList<Human> exclude(ArrayList<Human> humanList,Human human){
        ArrayList<Human> result = new ArrayList<>();
        for (Human value : humanList) {
            if (value != human) {
                result.add(value.copy());
            }
        }
        return result;
    }

    public static List<Set<Integer>> getNotIntersection(List<Set<Integer>> a, Set<Integer> b){
        List<Set<Integer>> result = new ArrayList<>();
        for (Set<Integer> integers : a) {
            Set<Integer> temp = new HashSet<>(integers);
            temp.retainAll(b);
            if (temp.isEmpty()) {
                result.add(integers);
            }
        }
        return result;

    }
    public static HashSet<Human> getHumanByMaxAge(ArrayList<Human> humanList){
        HashSet<Human> result = new HashSet<>();
        int maxAge = 0;
        for (Human human : humanList) {
            maxAge = Math.max(maxAge, human.getAge());
        }
        for (Human human : humanList) {
            if (human.getAge() == maxAge) {
                result.add(human);
            }
        }
        return result;
    }

}
