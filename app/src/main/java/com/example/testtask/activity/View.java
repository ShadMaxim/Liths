package com.example.testtask.activity;

import com.example.testtask.repository.Person;

import java.util.List;

interface View {

    void showList(List<Person> list);
}
