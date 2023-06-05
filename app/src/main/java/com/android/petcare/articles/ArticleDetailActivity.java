package com.android.petcare.articles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.databinding.ActivityArticleDetailBinding;
import com.bumptech.glide.Glide;

public class ArticleDetailActivity extends AppCompatActivity {

    ActivityArticleDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_detail);
        setContentView(binding.getRoot());

        int articleId = getIntent().getIntExtra("articleId", 0);
        AppDatabase db = AppDatabase.getDbInstance(this);
        db.articlesDao().getArticle(articleId).observe(ArticleDetailActivity.this, article -> {
            binding.detailTitle.setText(article.getTitle());
            binding.detailDesc.setText(article.getShortDesc() + article.getDescription());
            Glide.with(this).load(article.getImage()).into(binding.imagedetail);
        });

    }
}