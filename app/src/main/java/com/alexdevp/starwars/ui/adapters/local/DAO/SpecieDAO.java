package com.alexdevp.starwars.ui.adapters.local.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alexdevp.starwars.model.Specie;

@Dao
public interface SpecieDAO {
    @Query("SELECT * from Specie")
    Specie[] getSpecies();

    @Query("SELECT * FROM Specie WHERE name=:nameSpecie")
    Specie getSpecieByName(String nameSpecie);

    @Query("DELETE FROM Specie")
    void deleteAllSpecies();

    @Insert
    void addSpecies(Specie[] species);
}
