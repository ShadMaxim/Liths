package com.example.testtask.repository;

import java.util.ArrayList;

public class Person {

    public int id;
    public String name;
    public int age;
    public int weight;
    public int growth;

    private ArrayList<Person> personList = new ArrayList<>();

    public Person(int id, String name, int age, int weight, int growth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.growth = growth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }
}