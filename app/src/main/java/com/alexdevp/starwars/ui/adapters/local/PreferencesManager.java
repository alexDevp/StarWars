package com.alexdevp.starwars.ui.adapters.local;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {

    private static String PREFERENCES_NAME = "prefs";
    private static String SAVED_DATE_KEY_PLANET = "lastSavedDate";

    public static long getLastSavedDatePlanets(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(SAVED_DATE_KEY_PLANET, 0);
    }

    public static void saveLastSavedDatePlanets(Context context, long date) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(SAVED_DATE_KEY_PLANET, date).apply();
    }
}