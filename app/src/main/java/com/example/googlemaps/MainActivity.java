package com.example.googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username;
    EditText password;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbHelper helper = new DbHelper(this);
        db = helper.getWritableDatabase();

        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(username.getText().toString())) {
                    username.setError("Username is Required");
                    return;
                }


                if(TextUtils.isEmpty(password.getText().toString())) {
                    password.setError("Password is Required");
                    return;
                }

                if (username.getText().toString().equals( "ghayoor") && password.getText().toString().equals("00000")){

                    Intent i = new Intent(MainActivity.this, maps.class);
                    startActivity(i);
                    finish();

                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Wrong Credentials",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }



            }
        });



    }
}
