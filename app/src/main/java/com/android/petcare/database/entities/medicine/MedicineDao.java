package com.android.petcare.database.entities.medicine;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.android.petcare.database.entities.user.User;

import java.util.List;

@Dao
public interface MedicineDao {
    @Query("Select * from Medicine")
    LiveData<List<Medicine>> getAll();

    @Insert
    void insert(Medicine medicine);

}
