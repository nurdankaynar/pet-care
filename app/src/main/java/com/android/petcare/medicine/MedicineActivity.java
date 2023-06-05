package com.android.petcare.medicine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.database.entities.medicine.Medicine;
import com.android.petcare.databinding.ActivityLabTestBinding;
import com.android.petcare.databinding.ActivityMedicineBinding;
import com.android.petcare.labtest.LabTestActivity;
import com.android.petcare.labtest.LabTestAdapter;
import com.android.petcare.labtest.TestDetailActivity;

public class MedicineActivity extends AppCompatActivity {

    MedicineAdapter adapter;

    ActivityMedicineBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_medicine);
        setContentView(binding.getRoot());

        AppDatabase db = AppDatabase.getDbInstance(this);

        db.medicineDao().getAll().observe(this, list -> {
            adapter = new MedicineAdapter(list);
            binding.rvItems.setHasFixedSize(true);
            binding.rvItems.setLayoutManager(new LinearLayoutManager(this));
            binding.rvItems.setAdapter(adapter);
        });
    }
}