package com.android.petcare.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.database.entities.articles.Articles;
import com.android.petcare.databinding.ActivityAddArticleBinding;
import com.android.petcare.databinding.ActivityArticleDetailBinding;

public class AddArticleActivity extends AppCompatActivity {

    ActivityAddArticleBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_article);

        setContentView(binding.getRoot());
        binding.btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AppDatabase db = AppDatabase.getDbInstance(AddArticleActivity.this);

                Articles article = new Articles();
                article.setTitle(binding.etTitle.getText().toString());
                article.setShortDesc(binding.etShortDesc.getText().toString());
                article.setDescription(binding.etDesc.getText().toString());
                article.setImage(binding.etImageLink.getText().toString());
                db.articlesDao().insert(article);

                binding.etImageLink.setText("");
                binding.etDesc.setText("");
                binding.etTitle.setText("");
                binding.etShortDesc.setText("");
            }
        });
    }
}