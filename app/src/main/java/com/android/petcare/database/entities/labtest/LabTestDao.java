package com.android.petcare.database.entities.labtest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LabTestDao {
    @Query("Select * from LabTest where clientId=:clientId")
    LiveData<List<LabTest>> getAllUsersLabTest(int clientId);

    @Query("Select * from LabTest where fie_id=:testId")
    LiveData<LabTest> getLabTest(int testId);
    @Insert
    void insert(LabTest labTest);
}