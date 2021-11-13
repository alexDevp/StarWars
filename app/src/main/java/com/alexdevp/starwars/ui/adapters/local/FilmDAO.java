package com.alexdevp.starwars.ui.adapters.local;


import androidx.room.Dao;
import androidx.room.Query;

import com.alexdevp.starwars.model.Film;

import java.util.List;


@Dao
public interface FilmDAO {
    @Query("SELECT * from Film")
    List<Film> getPlanets();

    @Query("SELECT * FROM Film WHERE title=:titleFilm")
    Film getPlanetById(String titleFilm);

    //@Query("SELECT * FROM message WHERE timestamp > :timestamp")
    //List<Message> getNewMessages(long timestamp);
}
