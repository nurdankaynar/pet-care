package com.android.petcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.petcare.admin.AdminActivity;
import com.android.petcare.database.entities.AppDatabase;
import com.android.petcare.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    String UsrName, UsrPass, CorrUsr = "user", CorrPass = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        setContentView(binding.getRoot());


        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsrName = binding.username.getText().toString();
                UsrPass = binding.password.getText().toString();
                if (!TextUtils.isEmpty(UsrName) && !TextUtils.isEmpty(UsrPass)) {
                    if (UsrName.equals("admin") && UsrPass.equals("1234")) {
                        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                        finish();
                        startActivity(intent);
                    } else {
                        AppDatabase db = AppDatabase.getDbInstance(LoginActivity.this);
                        db.userDao().getUser(UsrName, UsrPass).observe(LoginActivity.this, user -> {
                            if (user == null) {
                                Toast.makeText(LoginActivity.this, "Kullanıcı adı veya şifre yanlış", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                intent.putExtra("userId", user.getFie_id());
                                finish();
                                startActivity(intent);
                            }
                        });
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Kullanıcı adı veya şifre boş bırakılamaz", Toast.LENGTH_SHORT).show();
                }
            }

        });

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

}