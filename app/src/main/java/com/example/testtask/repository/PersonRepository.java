package com.example.testtask.repository;

import java.util.ArrayList;

public class PersonRepository {

    private static ArrayList<Person> personList;/* = new ArrayList<>();*/

    public static ArrayList<Person> listPerson() {

        if (personList == null){
            personList = new ArrayList<>();
            createListPerson();
        }
        return personList;
    }

    private PersonRepository() {
    }

    private static void createListPerson(){
        personList.add(new Person(1, "Sam", 20, 151, 52));
        personList.add(new Person(2, "Max", 24, 184, 71));
        personList.add(new Person(3, "Petr", 29, 170, 66));
        personList.add(new Person(4, "Igor", 32, 166, 70));
        personList.add(new Person(5, "Tom", 37, 190, 80));
    }
}
