package com.example.appi_16_2_off.Model;

import java.util.ArrayList;

public class Search {

    private ArrayList<Images> results;


    public Search(ArrayList<Images> results) {
        this.results = results;
    }

    public ArrayList<Images> getResults() {
        return results;
    }

    public void setResults(ArrayList<Images> results) {
        this.results = results;
    }
}
