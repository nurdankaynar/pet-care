package com.android.petcare.database.entities.articles;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Articles implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int fie_id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "shortDesc")
    private String shortDesc;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "image")
    private String image;


    public int getFie_id() {
        return fie_id;
    }

    public void setFie_id(int fie_id) {
        this.fie_id = fie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
