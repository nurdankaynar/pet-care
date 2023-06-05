package com.android.petcare.database.entities.user;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.android.petcare.database.entities.articles.Articles;

import java.util.List;

@Dao
public interface UserDao {
    @Query("Select * from User")
    LiveData<List<User>> getAll();

    @Insert
    void insert(User user);


    @Query("Select * from User where email=:email and password=:pasword")
    LiveData<User> getUser(String email, String pasword);

}
