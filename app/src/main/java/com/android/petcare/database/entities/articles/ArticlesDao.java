package com.android.petcare.database.entities.articles;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.android.petcare.database.entities.user.User;

import java.util.List;

@Dao
public interface ArticlesDao {
    @Query("Select * from Articles")
    LiveData<List<Articles>> getAll();

    @Query("Select * from Articles where fie_id=:articleId")
    LiveData<Articles> getArticle(int articleId);

    @Insert
    void insert(Articles articles);
}