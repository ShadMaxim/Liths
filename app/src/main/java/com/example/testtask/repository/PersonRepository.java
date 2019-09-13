package com.example.testtask.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;

public class PersonRepository {

    private static ArrayList<Person> personList;

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
        personList.add(new Person(6, "Kat", 41, 172, 78));
        personList.add(new Person(7, "Lis", 51, 174, 84));
        personList.add(new Person(8, "Den", 55, 195, 81));
        personList.add(new Person(9, "Ivan", 44, 191, 92));
        personList.add(new Person(10, "Mat", 29, 187, 77));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<Person> sort() {

        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {

                if (person.name.equals(t1.name)) return 0;
                else if ((person.name.compareTo(t1.name)) > 0) return 1;
                else return -1;
            }
        });

        return personList;
    }
}
