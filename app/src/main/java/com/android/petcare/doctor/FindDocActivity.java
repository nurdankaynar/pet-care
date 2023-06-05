package com.android.petcare.doctor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.databinding.ActivityFindDocBinding;

public class FindDocActivity extends AppCompatActivity {

    VetAdapter adapter;

    ActivityFindDocBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_find_doc);
        setContentView(binding.getRoot());
        AppDatabase db = AppDatabase.getDbInstance(this);

        db.veterinerDao().getAll().observe(this, list -> {
            adapter = new VetAdapter(list);
            binding.rvItems.setHasFixedSize(true);
            binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
            binding.rvItems.setAdapter(adapter);
        });
    }
}