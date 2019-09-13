package com.example.testtask;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.testtask.repository.Person;
import com.example.testtask.repository.PersonRepository;

import java.util.ArrayList;

public class Presenter {

    private View view;

    void setView(View view) {
        this.view = view;
    }

    void detachView() {
        this.view = null;
    }

    ArrayList<Person> createNewList() {
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person(100, "qwe", 121, 125, 21));
        list.add(new Person(111, "QAZ", 12, 125, 21));
        list.add(new Person(122, "V FR", 125, 125, 21));
        list.add(new Person(133, "XCD", 125, 125, 21));

        view.showNewList(list);

        return list;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    ArrayList<Person> sortList() {

        view.showSortList(PersonRepository.sort());
        return PersonRepository.sort();
    }
}
