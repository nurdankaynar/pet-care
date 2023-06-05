package com.android.petcare.admin;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.database.entities.vet.Veteriner;
import com.android.petcare.databinding.ActivityAddDoctorBinding;

public class AddDoctorActivity extends AppCompatActivity {

    ActivityAddDoctorBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_doctor);

        setContentView(binding.getRoot());
        binding.btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AppDatabase db = AppDatabase.getDbInstance(AddDoctorActivity.this);

                Veteriner veteriner = new Veteriner();
                veteriner.setFirstName(binding.etTitle.getText().toString());
                veteriner.setLastName(binding.etShortDesc.getText().toString());
                veteriner.setClinic(binding.etDesc.getText().toString());
                veteriner.setRating(new Integer(binding.etImageLink.getText().toString()));
                db.veterinerDao().insert(veteriner);

                binding.etImageLink.setText("");
                binding.etDesc.setText("");
                binding.etTitle.setText("");
                binding.etShortDesc.setText("");
            }
        });
    }
}