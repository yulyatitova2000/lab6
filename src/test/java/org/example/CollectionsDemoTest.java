package org.example;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionsDemoTest {

    @org.junit.jupiter.api.Test
    void getCount() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("rtdg");
        stringList.add("rhjis");
        stringList.add("yeilh");
        stringList.add("sldl");

        assertEquals(2,CollectionsDemo.getCount(stringList,'r'));
    }
}