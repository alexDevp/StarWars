package com.alexdevp.starwars.ui.adapters.local.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alexdevp.starwars.model.Film;

@Dao
public interface FilmDAO {
    @Query("SELECT * from Film")
    Film[] getFilms();

    @Query("SELECT * FROM Film WHERE title=:titleFilm")
    Film getFilmByTitle(String titleFilm);

    @Query("DELETE FROM Film")
    void deleteAllFilms();

    @Insert
    void addFilms(Film[] films);

}
