package org.example;

import java.util.ArrayList;

public class DataDemo {
    public static ArrayList<Integer> getAll(Data data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        var result = new ArrayList<Integer>();
        for (int num : data) {
            result.add(num);
        }
        return result;
    }
}
