package com.example.testtask.test;

import com.example.testtask.repository.Person;

import java.util.ArrayList;
import java.util.List;

public class Qwerty {

    static List<Person> personList = new ArrayList<>();
    static String name = "a";

    public static void main(String[] args) {

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

        search(name);

    }

    static void search(String name){

        List<Person> newListPerson = new ArrayList<>();

        for (Person p : personList){
            if (p.getName() != null && p.getName().contains(name)){
                newListPerson.add(p);
            }
        }

        System.out.println(newListPerson.toString());
        System.out.println(newListPerson.size());
    }
}