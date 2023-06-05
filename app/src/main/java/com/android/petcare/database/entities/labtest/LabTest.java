package com.android.petcare.database.entities.labtest;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class LabTest implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int fie_id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "shortDesc")
    private String shortDesc;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "clientId")
    private int clientId;


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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

}
