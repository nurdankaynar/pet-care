package com.android.petcare.database.entities.vet;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.android.petcare.database.entities.user.User;

import java.util.List;

@Dao
public interface VeterinerDao {
    @Query("Select * from Veteriner")
    LiveData<List<Veteriner>> getAll();

    @Insert
    void insert(Veteriner user);

}
