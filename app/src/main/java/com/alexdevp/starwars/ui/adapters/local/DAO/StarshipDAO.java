package com.alexdevp.starwars.ui.adapters.local.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alexdevp.starwars.model.Starship;

@Dao
public interface StarshipDAO {
    @Query("SELECT * from Starship")
    Starship[] getStarships();

    @Query("SELECT * FROM Starship WHERE name=:nameStarship")
    Starship getStarshipByName(String nameStarship);

    @Query("DELETE FROM Starship")
    void deleteAllStarships();

    @Insert
    void addStarships(Starship[] starships);

}
