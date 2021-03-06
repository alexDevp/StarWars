package com.alexdevp.starwars.model;

import java.util.List;

public class FilmsResponse {
    private int count;
    private String next;
    private String previous;
    private Film[] results;

    public FilmsResponse(int count, String next, String previous, Film[] results) {
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

    public Film[] getResults() {
        return results;
    }
}
