package com.example.mark.gohike.dummy;

/**
 * Created by Bobby on 06/02/2018.
 */

public class Path {
    int image;
    double rating;
    String name, description, skill;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


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

    public void setSkill(String skill){ this.skill = skill; }
    public String getSkill(){
        return skill;
    }
}