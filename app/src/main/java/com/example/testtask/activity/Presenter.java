package com.example.testtask.activity;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testtask.app.App;
import com.example.testtask.dao.PersonDao;
import com.example.testtask.repository.Person;
import com.example.testtask.repository.PersonRepository;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class Presenter extends MvpPresenter<MyView> {

    private PersonDao personDao;

    public Presenter() {
        //getViewState().showList(PersonRepository.listPerson());
    }

    @Override
    protected void onFirstViewAttach() {
        getViewState().showToast("onFirstViewAttach() witch getViewState()");
        super.onFirstViewAttach();
    }

    {
        personDao = App.instance.getDatabase().PersonDao();
    }

    void loadList() {

        Completable.fromAction(() -> {
            List<Person> repository = PersonRepository.listPerson();
            personDao.insertPersonsList(repository);
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe();

        personDao.getPersonList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    getViewState().showList(list);
                });
    }

    @SuppressLint("CheckResult")
    void sortList() {

        List<Person> repository = PersonRepository.listPerson();
        getViewState().showToast(" sort()  with getViewState()");

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
                .subscribe(list -> {
                    //getViewState().clearEditText();
                    getViewState().showList(list);
                });
    }

    @SuppressLint("CheckResult")
    void searchUsers(String name) {

        getViewState().showToast(" searchUsers()  with getViewState()");

        List<Person> repository = PersonRepository.listPerson();

        io.reactivex.Observable
                .fromIterable(repository)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .filter(person -> person.getName().contains(name))
                .toList()
                .subscribe(list -> {
                    getViewState().showList(list);
                });
    }
}