package com.android.petcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.database.entities.user.User;
import com.android.petcare.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    String name, surName, mail, country, newPassword;

    ActivityRegisterBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        setContentView(binding.getRoot());

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = binding.name.getText().toString();
                surName = binding.surname.getText().toString();
                mail = binding.email.getText().toString();
                country = binding.country.getText().toString();
                newPassword = binding.newPassword.getText().toString();


                AppDatabase db = AppDatabase.getDbInstance(RegisterActivity.this);
                User user = new User();
                user.setFirstName(name);
                user.setLastName(surName);
                user.setEmail(mail);
                user.setCountry(country);
                user.setPassword(newPassword);
                db.userDao().insert(user);

                finish();
            }
        });


    }
}