package com.alexdevp.starwars.model;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Vehicle {

    @PrimaryKey
    @NonNull
    @SerializedName("name")
    private String name;
    @SerializedName("model")
    private String model;
    @SerializedName("manufacturer")
    private String manufacturer;
    @SerializedName("cost_in_credits")
    private String cost_in_credits;
    @SerializedName("length")
    private String length;
    @SerializedName("max_atmosphering_speed")
    private String max_atmosphering_speed;
    @SerializedName("crew")
    private String crew;
    @SerializedName("passengers")
    private String passengers;
    @SerializedName("cargo_capacity")
    private String cargo_capacity;
    @SerializedName("consumables")
    private String consumables;
    @SerializedName("vehicle_class")
    private String vehicle_class;
    @SerializedName("url")
    private String url;

    public Vehicle(@NonNull String name, String model, String manufacturer, String cost_in_credits,
                   String length, String max_atmosphering_speed, String crew, String passengers,
                   String cargo_capacity, String consumables, String vehicle_class, String url) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost_in_credits = cost_in_credits;
        this.length = length;
        this.max_atmosphering_speed = max_atmosphering_speed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargo_capacity = cargo_capacity;
        this.consumables = consumables;
        this.vehicle_class = vehicle_class;
        this.url = url;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getVehicle_class() {
        return vehicle_class;
    }

    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class = vehicle_class;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
