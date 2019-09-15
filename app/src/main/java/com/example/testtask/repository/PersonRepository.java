package com.example.testtask.repository;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private static List<Person> personList;

    public static List<Person> listPerson() {

        if (personList == null) {
            personList = new ArrayList<>();
            createListPerson();
        }
        return personList;
    }

    private PersonRepository() {
    }

    private static void createListPerson() {
        personList.add(new Person(1, "Sam", 20, 151, 52));
        personList.add(new Person(2, "Max", 24, 184, 71));
        personList.add(new Person(3, "Petr", 29, 170, 66));
        personList.add(new Person(4, "Igor", 32, 166, 70));
        personList.add(new Person(5, "Tom", 37, 190, 80));
        personList.add(new Person(6, "Kat", 41, 172, 78));
        personList.add(new Person(7, "Lis", 51, 174, 84));
        personList.add(new Person(8, "Den", 55, 195, 81));
        personList.add(new Person(9, "Ivan", 44, 191, 92));
        personList.add(new Person(10, "Mat", 29, 187, 77));
    }
}