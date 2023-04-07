package com.example.tooneactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetails extends AppCompatActivity {
    TextView email,address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);

        email=findViewById(R.id.textView);
        address=findViewById(R.id.textView2);


        Intent i = getIntent();

        String t1 = i.getStringExtra("email").toString();
        String t2 = i.getStringExtra("address").toString();

        email.setText(t1);
        address.setText(t2);
    }
}


