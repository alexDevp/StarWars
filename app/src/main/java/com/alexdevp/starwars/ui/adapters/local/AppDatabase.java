package com.alexdevp.starwars.ui.adapters.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.alexdevp.starwars.model.Film;
import com.alexdevp.starwars.model.People;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.model.Specie;
import com.alexdevp.starwars.model.Starship;
import com.alexdevp.starwars.model.Vehicle;
import com.alexdevp.starwars.ui.adapters.local.DAO.FilmDAO;
import com.alexdevp.starwars.ui.adapters.local.DAO.PeopleDAO;
import com.alexdevp.starwars.ui.adapters.local.DAO.PlanetDAO;
import com.alexdevp.starwars.ui.adapters.local.DAO.SpecieDAO;
import com.alexdevp.starwars.ui.adapters.local.DAO.StarshipDAO;
import com.alexdevp.starwars.ui.adapters.local.DAO.VehicleDAO;

@Database(entities = {People.class, Planet.class, Film.class, Specie.class, Vehicle.class, Starship.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PeopleDAO getPeopleDao();
    public abstract PlanetDAO getPlanetDao();
    public abstract FilmDAO getFilmDao();
    public abstract SpecieDAO getSpecieDao();
    public abstract VehicleDAO getVehicleDao();
    public abstract StarshipDAO getStarshipDao();
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
