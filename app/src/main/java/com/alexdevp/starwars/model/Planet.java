package com.alexdevp.starwars.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Planet implements Serializable {
    @PrimaryKey
    @NonNull
    @SerializedName("name")
    private String name;
    @SerializedName("rotation_period")
    private String rotationPeriod;
    @SerializedName("orbital_period")
    private String orbitalPeriod;
    @SerializedName("diameter")
    private String diameter;
    @SerializedName("climate")
    private String climate;
    @SerializedName("gravity")
    private String gravity;
    @SerializedName("terrain")
    private String terrain;
    @SerializedName("surface_water")
    private String surfaceWater;
    @SerializedName("population")
    private String population;



    public Planet(String name, String rotationPeriod, String orbitalPeriod, String diameter, String climate, String gravity, String terrain, String surfaceWater, String population) {
        this.name = name;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public String getPopulation() {
        return population;
    }
}
