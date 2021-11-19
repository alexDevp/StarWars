package com.alexdevp.starwars.ui.adapters.local.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alexdevp.starwars.model.People;

@Dao
public interface PeopleDAO {

    @Query("SELECT * from People")
    People[] getPeople();

    @Query("SELECT * FROM People WHERE name=:namePeople")
    People getPeopleByName(String namePeople);

    @Query("DELETE FROM People")
    void deleteAllPeople();

    @Insert
    void addPeople(People[] people);

}
