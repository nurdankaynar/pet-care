package com.android.petcare.database.entities.reminder;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Delete;
import androidx.room.Update;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReminderDAO {


    @Insert
    public void Insert(Reminders... reminders);

    @Update
    public void Update(Reminders... reminders);

    @Delete
    public void Delete(Reminders reminders);

    @Query("Select * from reminder order by remindDate")
    public List<Reminders> orderThetable();

    @Query("Select * from reminder Limit 1")
    public Reminders getRecentEnteredData();

    @Query("Select * from reminder")
    public List<Reminders> getAll();

}
