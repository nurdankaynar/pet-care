package com.android.petcare.articles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.databinding.ActivityArticlesBinding;

public class ArticlesActivity extends AppCompatActivity {

    ArticlesAdapter adapter;
    ActivityArticlesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_articles);
        setContentView(binding.getRoot());

        AppDatabase db = AppDatabase.getDbInstance(this);
        db.articlesDao().getAll().observe(this, list -> {
            adapter = new ArticlesAdapter(list, new ArticlesAdapter.ArticleItemListener() {
                @Override
                public void onItemClick(int articleId) {
                    Intent intent = new Intent(ArticlesActivity.this, ArticleDetailActivity.class);
                    intent.putExtra("articleId", articleId);
                    startActivity(intent);
                }
            });
            binding.rvItems.setHasFixedSize(true);
            binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
            binding.rvItems.setAdapter(adapter);
        });

    }
}