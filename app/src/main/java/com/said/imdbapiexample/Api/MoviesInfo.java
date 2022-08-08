package com.said.imdbapiexample.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoviesInfo {


    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("year")
    @Expose
    public String year;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("rank")
    @Expose
    public String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
