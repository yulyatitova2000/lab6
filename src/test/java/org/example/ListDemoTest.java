package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListDemoTest {

    @Test
    void getByLastName() {
        Human human = new Human("Сергей", "Смирнов", "Иванович", 34);
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Иван", "Иванов", "Иванович", 34));
        humanList.add(new Human("Влад", "Смирнов", "Иванович", 34));
        humanList.add(new Human("Иван", "Чирков", "Иванович", 34));
        humanList.add(new Human("Иван", "Петров", "Иванович", 34));
        humanList.add(new Human("Иван", "Смирнов", "Иванович", 34));

        List<Human> testList = ListDemo.getByLastName(humanList, human);
        assertEquals(2, testList.size());
        assertEquals("Смирнов", testList.get(0).getLastName());
        assertEquals("Смирнов", testList.get(1).getLastName());


    }

    @Test
    void exclude() {

        ArrayList<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Иван", "Иванов", "Иванович", 34));
        humanList.add(new Human("Влад", "Смирнов", "Иванович", 24));
        humanList.add(new Human("Иван", "Чирков", "Иванович", 45));
        humanList.add(new Human("Иван", "Петров", "Иванович", 56));
        humanList.add(new Human("Иван", "Смирнов", "Иванович", 34));

        ArrayList<Human> testList = ListDemo.exclude(humanList, humanList.get(1));
        assertEquals(4, testList.size());


    }

    @Test
    void getNotIntersection() {
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(41);
        a.add(43);
        a.add(44);
        a.add(45);
        a.add(46);
        a.add(47);
        a.add(48);
        a.add(49);
        a.add(444);
        a.add(1444);
        a.add(2444);
        a.add(3444);
        a.add(4444);
        a.add(5444);
        for (Integer item: a){
            System.out.print(item + " ");
        }
        Set<Integer> b = new LinkedHashSet<>();
        b.add(5);
        b.add(6);
        b.add(7);
        System.out.println();
        for (Integer item: b){
            System.out.print(item + " ");
        }
        Set<Integer> c = new TreeSet<>();
        c.add(130000);
        c.add(393);
        c.add(110333);
        System.out.println();
        for (Integer item: c){
            System.out.print(item + " ");
        }
        List<Set<Integer>> f = new ArrayList<>();
        f.add(a);
        f.add(b);
        f.add(c);
        HashSet<Integer> d = new HashSet<>();
        d.add(1);
        d.add(11);
        d.add(12);
        List<Set<Integer>> actual = ListDemo.getNotIntersection(f, d);

        List<Set<Integer>> expected = new ArrayList<>();

        expected.add(0, new HashSet<>(b));
        expected.add(1, new HashSet<>(c));

        assertEquals(expected, actual);


    }

    @Test
    void getHumanByMaxAge() {
        ArrayList<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Иван", "Иванов", "Иванович", 34));
        humanList.add(new Human("Влад", "Смирнов", "Иванович", 24));
        humanList.add(new Human("Иван", "Чирков", "Иванович", 45));
        humanList.add(new Student("Иван", "Петров", "Иванович", 56, "математический"));
        humanList.add(new Human("Иван", "Смирнов", "Иванович", 34));
        HashSet<Human> result = ListDemo.getHumanByMaxAge(humanList);
        assertEquals(1, result.size());
        assertTrue(result.contains(humanList.get(3)));
        System.out.println(result);
    }
}