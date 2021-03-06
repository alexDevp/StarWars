package com.alexdevp.starwars.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Film implements Serializable {

    @PrimaryKey
    @NonNull
    @SerializedName("title")
    private String title;
    @SerializedName("episode_id")
    private String episodeId;
    @SerializedName("opening_crawl")
    private String openingCrawl;
    @SerializedName("director")
    private String director;
    @SerializedName("producer")
    private String producer;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("url")
    private String url;

    public Film(String title, String episodeId, String openingCrawl, String director, String producer, String releaseDate, String url) {
        this.title = title;
        this.episodeId = episodeId;
        this.openingCrawl = openingCrawl;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getUrl() {
        return url;
    }
}
