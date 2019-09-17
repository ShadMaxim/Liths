package com.example.testtask.repository;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PERSON_TABLE")
public class Person {

    @PrimaryKey
    public int id;
    public String name;
    public int age;
    public int weight;
    public int growth;

    public Person(int id, String name, int age, int weight, int growth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.growth = growth;
    }

    public String getName() {
        return name;
    }
}