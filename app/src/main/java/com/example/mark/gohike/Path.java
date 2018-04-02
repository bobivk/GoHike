package com.example.mark.gohike;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bobby on 06/02/2018.
 */

public class Path implements Serializable{
    public String name;
    public String description;
    public String difficulty;
    public Double rating;
    public Long length;
    public Integer image;


    public Path (String name, String description, String difficulty, Double rating, Long length, Integer image){
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.rating = rating;
        this.length = length;
        this.image = image;
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

/*
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

    //parcel

    protected Path(Parcel in) {
        name = in.readString();
        description = in.readString();
        difficulty = in.readString();
        rating = in.readByte() == 0x00 ? null : in.readDouble();
        length = in.readByte() == 0x00 ? null : in.readLong();
        image = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(difficulty);
        if (rating == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(rating);
        }
        if (length == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeLong(length);
        }
        if (image == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(image);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() {
        @Override
        public Path createFromParcel(Parcel in) {
            return new Path(in);
        }

        @Override
        public Path[] newArray(int size) {
            return new Path[size];
        }
    };
*/
}
