package com.example.testtask.repository;

import java.util.ArrayList;

public class Person {

    private int id;
    private String name;
    private int age;
    private int weight;
    private int growth;

    private ArrayList<Person> personList = new ArrayList<>();

    Person(int id, String name, int age, int weight, int growth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.growth = growth;
    }
}