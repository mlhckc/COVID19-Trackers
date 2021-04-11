package com.example.covid19t;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;

    EditText username,password,repasword;
    Button btnSignUp , btnSignIn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editTextTextPersonName);
        password = (EditText)findViewById(R.id.editTextTextPassword);

        btnSignUp = (Button) findViewById(R.id.button3);
        btnSignIn = (Button) findViewById(R.id.button);

        myDB = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this, "Fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "password not Matching", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Activity2.class);
                //startActivity(intent);
                  }
           });
    }

   public void openActivity2() {
       Intent intent = new Intent(this, Activity2.class);
      startActivity(intent);
    }
}