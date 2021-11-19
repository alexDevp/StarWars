package com.alexdevp.starwars.model;

public class PeopleResponse {
    private int count;
    private String next;
    private String previous;
    private People[] results;

    public PeopleResponse(int count, String next, String previous, People[] results) {
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

    public People[] getResults() {
        return results;
    }
}
