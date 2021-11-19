package com.alexdevp.starwars.model;

public class VehiclesResponse {
    private int count;
    private String next;
    private String previous;
    private Vehicle[] results;

    public VehiclesResponse(int count, String next, String previous, Vehicle[] results) {
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

    public Vehicle[] getResults() {
        return results;
    }
}
