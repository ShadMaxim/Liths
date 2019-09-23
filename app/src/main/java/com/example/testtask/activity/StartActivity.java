package com.example.testtask.activity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.testtask.R;
import com.example.testtask.adapter.MyAdapter;
import com.example.testtask.repository.Person;

import java.util.Collections;
import java.util.List;

public class StartActivity extends MvpAppCompatActivity implements MyView {

    @InjectPresenter
    public Presenter presenter;

    MyAdapter adapter;
    Button sortButton;
    EditText searchByCharName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_layout);

        // presenter = new Presenter();
        // presenter.setView(this);

        sortButton = findViewById(R.id.sortButton);
        searchByCharName = findViewById(R.id.searchByCharName);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(Collections.emptyList());

        presenter.loadList();

        DividerItemDecoration decor = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        recyclerView.addItemDecoration(decor);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        searchByCharName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charName, int i, int i1, int i2) {

                presenter.searchUsers(charName.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sortButton.setOnClickListener(view ->
                presenter.sortList());
    }

    @Override
    public void showList(List<Person> list) {
        adapter.update(list);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearEditText() {
        searchByCharName.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //presenter.detachView();
    }
}