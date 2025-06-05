package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneBook {
    private Map<Human, ArrayList<String>> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void addPhone(Human K, String V) {
        if (K == null) {
            throw new IllegalArgumentException();
        }
        if (V == null) {
            throw new IllegalArgumentException();
        }
        if (this.getHumanWithPhone(V) != null) {
            throw new IllegalArgumentException();
        }
        if (map.containsKey(K)) {
            map.get(K).add(V);
        } else {
            map.put(K, new ArrayList<>());
            map.get(K).add(V);
        }
    }

    public void removePhone(Human K, String V) {
        if (K == null) {
            throw new IllegalArgumentException();
        }
        if (!map.containsKey(K)) {
            throw new IllegalArgumentException();
        } else {
            map.get(K).remove(V);
            if (map.get(K).isEmpty()) {
                map.remove(K);
            }
        }
    }

    public ArrayList<String> getAllPhone(Human K) {
        if (K == null) {
            throw new IllegalArgumentException();
        }
        if (!map.containsKey(K)) {
            throw new IllegalArgumentException();
        } else {
            return map.get(K);
        }
    }

    public Human getHumanWithPhone(String V) {
        if (V == null) {
            throw new IllegalArgumentException();
        }
        Human result = null;
        for (Map.Entry<Human, ArrayList<String>> entry : map.entrySet()) {
            for (String phone : entry.getValue()) {
                if (V.equals(phone)) {
                    result = entry.getKey();
                    break;
                }
            }
        }
        return result;
    }

    public PhoneBook getPhoneBookStartWith(String start) {
        if (start == null) {
            throw new IllegalArgumentException();
        }
        PhoneBook result = new PhoneBook();
        for (Map.Entry<Human, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getKey().getLastName().startsWith(start)) {
                for (String phone : entry.getValue()) {
                    result.addPhone(entry.getKey(), phone);
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) object;
        return Objects.equals(map, phoneBook.map);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(map);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "map=" + map +
                '}';
    }
}
