package com.alexdevp.starwars.model;

import java.util.List;

public class PlanetsResponse {
    private int count;
    private String next;
    private String previous;
    private List<Planet> results;

    public PlanetsResponse(int count, String next, String previous, List<Planet> results) {
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

    public List<Planet> getResults() {
        return results;
    }
}
