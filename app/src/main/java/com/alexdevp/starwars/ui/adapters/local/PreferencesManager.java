package com.alexdevp.starwars.ui.adapters.local;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    private static String PREFERENCES_NAME = "prefs";
    private static String SAVED_DATE_KEY_PEOPLE = "lastSavedDatePeople";
    private static String SAVED_DATE_KEY_PLANET = "lastSavedDatePlanet";
    private static String SAVED_DATE_KEY_FILM = "lastSavedDateFilms";
    private static String SAVED_DATE_KEY_SPECIE = "lastSavedDateSpecies";
    private static String SAVED_DATE_KEY_VEHICLE = "lastSavedDateVehicles";
    private static String SAVED_DATE_KEY_STARSHIP = "lastSavedDateStarships";

    //PEOPLE
    public static long getLastSavedDatePeople(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(SAVED_DATE_KEY_PEOPLE, 0);
    }

    public static void saveLastSavedDatePeople(Context context, long date) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(SAVED_DATE_KEY_PEOPLE, date).apply();
    }

    //PLANETS
    public static long getLastSavedDatePlanets(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(SAVED_DATE_KEY_PLANET, 0);
    }

    public static void saveLastSavedDatePlanets(Context context, long date) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(SAVED_DATE_KEY_PLANET, date).apply();
    }

    //FILMS
    public static long getLastSavedDateFilms(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(SAVED_DATE_KEY_FILM, 0);
    }

    public static void saveLastSavedDateFilms(Context context, long date) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(SAVED_DATE_KEY_FILM, date).apply();
    }

    //SPECIES

    public static long getLastSavedDateSpecies(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(SAVED_DATE_KEY_SPECIE, 0);
    }

    public static void saveLastSavedDateSpecies(Context context, long date) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(SAVED_DATE_KEY_SPECIE, date).apply();
    }

    //VEHICLES

    public static long getLastSavedDateVehicles(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(SAVED_DATE_KEY_VEHICLE, 0);
    }

    public static void saveLastSavedDateVehicles(Context context, long date) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(SAVED_DATE_KEY_VEHICLE, date).apply();
    }

    //STARSHIPS

    public static long getLastSavedDateStarships(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(SAVED_DATE_KEY_STARSHIP, 0);
    }

    public static void saveLastSavedDateStarships(Context context, long date) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(SAVED_DATE_KEY_STARSHIP, date).apply();
    }
}