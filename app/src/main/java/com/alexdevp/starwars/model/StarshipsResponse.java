package com.alexdevp.starwars.model;

public class StarshipsResponse {
    private int count;
    private String next;
    private String previous;
    private Starship[] results;

    public StarshipsResponse(int count, String next, String previous, Starship[] results) {
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

    public Starship[] getResults() {
        return results;
    }
}
