package com.example.testtask.app;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.testtask.dao.PersonDao;
import com.example.testtask.repository.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract PersonDao PersonDao();
}