package com.said.imdbapiexample.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemsInfo {

    @SerializedName("items")
    @Expose
    private List<MoviesInfo> items;

    public List<MoviesInfo> getItems() {
        return items;
    }

    public void setItems(List<MoviesInfo> items) {
        this.items = items;
    }
}
