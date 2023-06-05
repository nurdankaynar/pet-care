package com.android.petcare.labtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.android.petcare.R;

import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.databinding.ActivityLabTestBinding;

public class LabTestActivity extends AppCompatActivity {

    LabTestAdapter adapter;

    ActivityLabTestBinding binding;
    int userId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lab_test);
        setContentView(binding.getRoot());
        userId = getIntent().getIntExtra("userId", -1);

        AppDatabase db = AppDatabase.getDbInstance(this);

        db.labTestDao().getAllUsersLabTest(userId).observe(this, list -> {
            adapter = new LabTestAdapter(list, new LabTestAdapter.LabTestItemListener() {
                @Override
                public void onItemClick(int testId) {
                    Intent intent = new Intent(LabTestActivity.this, TestDetailActivity.class);
                    intent.putExtra("testId", testId);
                    startActivity(intent);
                }
            });
            binding.rvItems.setHasFixedSize(true);
            binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
            binding.rvItems.setAdapter(adapter);
        });
    }
}