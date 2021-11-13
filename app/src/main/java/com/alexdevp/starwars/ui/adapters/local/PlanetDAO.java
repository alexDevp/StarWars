package com.alexdevp.starwars.ui.adapters.local;


import androidx.room.Dao;
import androidx.room.Query;

import com.alexdevp.starwars.model.Planet;

import java.util.List;


@Dao
public interface PlanetDAO {
    @Query("SELECT * from Planet")
    List<Planet> getPlanets();

    @Query("SELECT * FROM Planet WHERE name=:namePlanet")
    Planet getPlanetById(long namePlanet);

    //@Query("SELECT * FROM message WHERE timestamp > :timestamp")
    //List<Message> getNewMessages(long timestamp);
}
