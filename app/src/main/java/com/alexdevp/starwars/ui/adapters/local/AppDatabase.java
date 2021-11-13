package com.alexdevp.starwars.ui.adapters.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.alexdevp.starwars.model.Film;
import com.alexdevp.starwars.model.Planet;

@Database(entities = {Planet.class, Film.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PlanetDAO getPlanetDao();
    public abstract FilmDAO getFilmDao();
    private static AppDatabase INSTANCE;

    public synchronized static AppDatabase getInstance(Context context) {
        if (null == INSTANCE) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                    "StarWarsDB")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                }
            }).build();
        }
        return INSTANCE;
    }

}
