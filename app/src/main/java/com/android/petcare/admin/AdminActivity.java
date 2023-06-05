package com.android.petcare.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.petcare.LoginActivity;
import com.android.petcare.R;
import com.android.petcare.databinding.ActivityAdminBinding;

public class AdminActivity extends AppCompatActivity {
    ActivityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_admin);

        setContentView(binding.getRoot());

        binding.btnAddLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, AddLabTestActivity.class));
            }
        });


        binding.btnAddArticle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, AddArticleActivity.class));
            }
        });

        binding.btnAddDoctor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, AddDoctorActivity.class));
            }
        });

        binding.btnAddMedicine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, AddMedicineActivity.class));
            }
        });

        binding.btnLogOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}