package com.example.testtask.activity;

import android.annotation.SuppressLint;
import com.example.testtask.repository.Person;
import com.example.testtask.repository.PersonRepository;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class Presenter {

    private View view;

    void setView(View view) {
        this.view = view;
    }

    void detachView() {
        this.view = null;
    }

    @SuppressLint("CheckResult")
    void sortList() {

        List<Person> repository = PersonRepository.listPerson();

        io.reactivex.Observable
                .just(repository)
                .flatMapIterable(listPerson -> listPerson)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .toSortedList((person, t1) -> {

                    if (person.name.equals(t1.name)) return 0;
                    else if ((person.name.compareTo(t1.name)) > 0) return 1;
                    else return -1;
                })
                .subscribe(list -> view.showList(list));
    }

    @SuppressLint("CheckResult")
    void searchUsers(String name) {

        List<Person> repository = PersonRepository.listPerson();

        io.reactivex.Observable
                .fromIterable(repository)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .filter(person -> person.getName().contains(name))
                .toList()
                .subscribe(list -> view.showList(list));
    }
}
