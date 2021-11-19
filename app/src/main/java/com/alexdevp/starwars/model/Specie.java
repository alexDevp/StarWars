package com.alexdevp.starwars.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Specie {
    @PrimaryKey
    @NonNull
    @SerializedName("name")
    private String name;
    @SerializedName("classification")
    private String classification;
    @SerializedName("designation")
    private String designation;
    @SerializedName("average_height")
    private String average_height;
    @SerializedName("skin_colors")
    private String skin_colors;
    @SerializedName("hair_colors")
    private String hair_colors;
    @SerializedName("eye_colors")
    private String eye_colors;
    @SerializedName("average_lifespan")
    private String average_lifespan;
    @SerializedName("language")
    private String language;
    @SerializedName("url")
    private String url;

    public Specie(@NonNull String name, String classification, String designation,
                  String average_height, String skin_colors, String hair_colors, String eye_colors,
                  String average_lifespan, String language, String url) {
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.average_height = average_height;
        this.skin_colors = skin_colors;
        this.hair_colors = hair_colors;
        this.eye_colors = eye_colors;
        this.average_lifespan = average_lifespan;
        this.language = language;
        this.url = url;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAverage_height() {
        return average_height;
    }

    public void setAverage_height(String average_height) {
        this.average_height = average_height;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public void setEye_colors(String eye_colors) {
        this.eye_colors = eye_colors;
    }

    public String getAverage_lifespan() {
        return average_lifespan;
    }

    public void setAverage_lifespan(String average_lifespan) {
        this.average_lifespan = average_lifespan;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
