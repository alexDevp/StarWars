package com.alexdevp.starwars.model;

public class SpeciesResponse {
    private int count;
    private String next;
    private String previous;
    private Specie[] results;

    public SpeciesResponse(int count, String next, String previous, Specie[] results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public Specie[] getResults() {
        return results;
    }
}
