package org.example;

import java.util.Objects;

public class Human {
    private String firstName;
    private String lastName;
    private String surName;
    private int age;

    public Human(String firstName, String lastName, String surName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName) && Objects.equals(surName, human.surName);
    }

    @Override
    public String toString() {
        return "Human{" + "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, surName, age);
    }

    public Human copy(){
        return new Human(firstName, lastName, surName, age);

    }
}
