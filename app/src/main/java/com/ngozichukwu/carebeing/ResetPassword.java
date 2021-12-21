package com.ngozichukwu.carebeing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword  extends AppCompatActivity {
    TextView login, register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.forgotpassword);

        login = findViewById(R.id.forgttpassword);
        register = findViewById(R.id.regform);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent example = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(example);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent example = new Intent(getApplicationContext(), Register.class);
                startActivity(example);
            }
        });
    }
}
