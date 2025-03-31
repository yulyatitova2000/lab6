package org.example;

import java.util.List;

public class CollectionsDemo {

    public static int getCount(List<String> stringList, char c) {
        int count = 0;
        for(int i =0; i < stringList.size(); i++) {
            if (stringList.get(i).charAt(0) == c) {
                count++;
            }
        }
        return count;
    }

}

