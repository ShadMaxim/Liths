package com.example.testtask;

import com.example.testtask.repository.Person;

import java.util.ArrayList;

interface View {

    void createList();
    void showNewList(ArrayList<Person> list);
    void showSortList(ArrayList<Person> list);
}
