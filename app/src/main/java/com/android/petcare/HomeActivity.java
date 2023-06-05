package com.android.petcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.petcare.articles.ArticlesActivity;
import com.android.petcare.doctor.FindDocActivity;
import com.android.petcare.labtest.LabTestActivity;
import com.android.petcare.medicine.MedicineActivity;

public class HomeActivity extends AppCompatActivity {
    int userId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        userId = getIntent().getIntExtra("userId", -1);

        CardView exit = findViewById(R.id.cardLogOut);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
            }
        });

        CardView labtest = findViewById(R.id.carLab);
        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LabTestActivity.class);
                intent.putExtra("userId", userId);
                startActivity(intent);
            }
        });

        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FindDocActivity.class));
            }
        });

        CardView medicine = findViewById(R.id.cardMedicine);
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MedicineActivity.class));
            }
        });

        CardView articles = findViewById(R.id.cardArticles);
        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ArticlesActivity.class));
            }
        });
    }
}