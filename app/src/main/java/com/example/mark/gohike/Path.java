package com.example.mark.gohike;

import android.media.Image;

/**
 * Created by Bobby on 06/02/2018.
 */

public class Path {
    int image;
    double rating;
    String name, description;
    String difficulty, length;


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setLength(String length){this.length = length;}
    public String getLength(){return length;}

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    } 

    public void setDifficulty(String difficulty){ this.difficulty = difficulty; }
    public String getDifficulty(){
        return difficulty;
    }
}
