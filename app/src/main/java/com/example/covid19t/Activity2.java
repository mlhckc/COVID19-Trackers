package com.example.covid19t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity2 extends AppCompatActivity {
    EditText name,surname,email,password;
    Button btnsave;

    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        name = (EditText) findViewById(R.id.editTextTextPersonName4);
        surname = (EditText) findViewById(R.id.editTextTextPersonName5);
        email = (EditText) findViewById(R.id.editTextTextPersonName6);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        btnsave = (Button) findViewById(R.id.button2);

        myDB =  new DBHelper(this);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = name.getText().toString();
                String surn = surname.getText().toString();
                String eml = email.getText().toString();
                String pass = password.getText().toString();

                if(name.equals("")|| surname.equals("")||email.equals("")||password.equals("")){
                    Toast.makeText(Activity2.this,"Please enter the credentials",Toast.LENGTH_SHORT).show();
                }
                else {
                   Boolean result = myDB.checkusernamePassword(eml,pass);
                   if(result == true){
                       Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                       startActivity(intent);
                   }
                   else{
                       Toast.makeText(Activity2.this,"Invalid Crediantials",Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });

    }
}