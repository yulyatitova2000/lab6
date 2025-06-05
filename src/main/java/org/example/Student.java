package org.example;

import java.util.Objects;

public class Student extends  Human{
    private String faculty;

    public Student(String firstName, String lastName, String surName, int age, String faculty) {
        super(firstName, lastName, surName, age);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty);
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                "} " + super.toString();
    }
}
