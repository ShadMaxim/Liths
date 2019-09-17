package com.example.testtask.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.testtask.repository.Person;

import java.util.List;

import io.reactivex.Maybe;


@Dao
public interface PersonDao {

    @Query("SELECT * FROM PERSON_TABLE")
    Maybe<List<Person>> getPersonList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPersonsList(List<Person> personList);
}