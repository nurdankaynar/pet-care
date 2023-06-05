package com.android.petcare.admin;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.database.entities.medicine.Medicine;
import com.android.petcare.databinding.ActivityAddMedicineBinding;

public class AddMedicineActivity extends AppCompatActivity {

    ActivityAddMedicineBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_medicine);

        setContentView(binding.getRoot());
        binding.btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AppDatabase db = AppDatabase.getDbInstance(AddMedicineActivity.this);

                Medicine medicine = new Medicine();
                medicine.setName(binding.etTitle.getText().toString());
                medicine.setDesc(binding.etDesc.getText().toString());
                medicine.setImage(binding.etImageLink.getText().toString());
                medicine.setPrice(binding.etPrice.getText().toString());
                db.medicineDao().insert(medicine);

                binding.etImageLink.setText("");
                binding.etDesc.setText("");
                binding.etTitle.setText("");
                binding.etPrice.setText("");
            }
        });
    }
}