package com.example.mark.gohike;

import android.media.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bobby on 06/02/2018.
 */

public class Path {
    public Integer image;
    public Double rating;
    public String name;
    public String description;
    public String difficulty;
    public Long length;


    public Path(){
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setLength(Long length){this.length = length;}
    public Long getLength(){return length;}

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


    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("image", image);
        map.put("rating", rating);
        map.put("name",name);
        map.put("description",description);
        map.put("difficulty",difficulty);
        map.put("length",length);
        return map;
    }
}
