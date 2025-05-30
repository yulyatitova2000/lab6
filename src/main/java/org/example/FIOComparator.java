package org.example;

import java.util.Comparator;

public class FIOComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getFIO().compareTo(h2.getFIO());
    }

}
