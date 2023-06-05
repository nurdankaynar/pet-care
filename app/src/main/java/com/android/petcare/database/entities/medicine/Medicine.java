package com.android.petcare.database.entities.medicine;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Medicine implements Serializable {
    public int getFie_id() {
        return fie_id;
    }

    public void setFie_id(int fie_id) {
        this.fie_id = fie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @PrimaryKey(autoGenerate = true)
    private int fie_id;
    @ColumnInfo(name = "firstName")
    private String name;
    @ColumnInfo(name = "lastName")
    private String desc;
    @ColumnInfo(name = "email")
    private String image;
    @ColumnInfo(name = "password")
    private String price;

}
