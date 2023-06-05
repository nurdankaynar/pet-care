package com.android.petcare.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.petcare.R;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.database.entities.labtest.LabTest;
import com.android.petcare.database.entities.user.User;
import com.android.petcare.databinding.ActivityAddLabTestBinding;

import java.util.ArrayList;
import java.util.List;

public class AddLabTestActivity extends AppCompatActivity {

    ActivityAddLabTestBinding binding;
    User selectedUser;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_lab_test);

        setContentView(binding.getRoot());
        AppDatabase db = AppDatabase.getDbInstance(AddLabTestActivity.this);
        db.userDao().getAll().observe(this, usersDB -> {
            if (usersDB.size() == 0) {
                Toast.makeText(AddLabTestActivity.this, "Lutfen once kullanici ekleyin", Toast.LENGTH_SHORT).show();
                onBackPressed();
                return;
            }
            selectedUser = usersDB.get(0);
            this.users = usersDB;
            List<String> nameSurnames = new ArrayList<String>();

            for (User viewValue : users) {
                nameSurnames.add(viewValue.getFirstName() + " " + viewValue.getLastName());
            }

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nameSurnames);

            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            binding.spinner.setAdapter(dataAdapter);

            binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    selectedUser = users.get(arg2);
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
        });
        binding.btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                LabTest labTest = new LabTest();
                labTest.setTitle(binding.etTitle.getText().toString());
                labTest.setShortDesc(binding.etShortDesc.getText().toString());
                labTest.setDesc(binding.etDesc.getText().toString());
                labTest.setDate(binding.etDate.getText().toString());
                labTest.setClientId(selectedUser.getFie_id());
                db.labTestDao().insert(labTest);

                binding.etDate.setText("");
                binding.etDesc.setText("");
                binding.etTitle.setText("");
                binding.etShortDesc.setText("");
            }
        });
    }
}