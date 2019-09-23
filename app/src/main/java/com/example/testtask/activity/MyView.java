package com.example.testtask.activity;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.testtask.repository.Person;
import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MyView extends MvpView {

    void showList(List<Person> list);
    void showToast(String text);
    void clearEditText();

}