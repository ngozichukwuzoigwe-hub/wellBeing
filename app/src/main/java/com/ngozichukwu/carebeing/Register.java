package com.ngozichukwu.carebeing;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText name, password, diet, mail;
    TextView login, resetpassword;
    Button signup;
    DBHandler DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationformactivity);

//        login = findViewById(R.id.);
//        resetpassword = findViewById(R.id.regform);
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        mail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        diet = (EditText) findViewById(R.id.editTextTextPersonName2);

        DB = new DBHandler(this);

        signup = (Button) findViewById(R.id.button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname = name.getText().toString();
                String diets = diet.getText().toString();
                String pass = password.getText().toString();
                String user = mail.getText().toString();

                if (fullname.equals(" ") || diets.equals("") || pass.equals("") || user.equals("")){
                                        Toast.makeText(Register.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuser = DB.checkusername(user);

                    if(checkuser == false ){
                        DB.insertData(fullname, user, diets, pass);

                        Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Register.this, "User already exist", Toast.LENGTH_SHORT).show();
                    }
                }

//                if (fullname.equals("") || diets.equals("") || pass.equals("") || user.equals("")){
//                    Toast.makeText(Register.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
//                } else {
//                    Boolean checkuser = DB.checkusername(user);
//                    if(checkuser==false){
//
//                        Boolean insert = DB.insertData(fullname, diets, user, pass);
//                        if(insert==true){
//                            Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getApplicationContext(), ListActivity.class);
//                            startActivity(intent);
//                        }else{
//                            Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
//                        }
//
//
//                    } else{
//                        Toast.makeText(Register.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
//                    }
//                }

            }
        });
    }
}

