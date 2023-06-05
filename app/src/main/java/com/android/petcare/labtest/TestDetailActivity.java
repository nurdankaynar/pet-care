package com.android.petcare.labtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.databinding.ActivityTestDetailBinding;

public class TestDetailActivity extends AppCompatActivity {

    ActivityTestDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_detail);
        setContentView(binding.getRoot());

        int articleId = getIntent().getIntExtra("testId", 0);
        AppDatabase db = AppDatabase.getDbInstance(this);
        db.labTestDao().getLabTest(articleId).observe(TestDetailActivity.this, test -> {
            binding.testTitle.setText(test.getTitle().toString());
            binding.testDate.setText(test.getDate());
            binding.detailDesc.setText(test.getShortDesc() + test.getDesc());
        });
    }
}
