package com.example.tooneactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetails extends AppCompatActivity {
    TextView email,address,details_id,user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);

        email = findViewById(R.id.textView);
        address = findViewById(R.id.textView2);
        details_id =findViewById(R.id.textView4);
        user_id= findViewById(R.id.textView3);





        Intent i = getIntent();

        String t1 = i.getStringExtra("email");
        String t2 = i.getStringExtra("address");
        long t3 = i.getLongExtra("detail id", 0);
        long t4 = i.getLongExtra("user id",0);


        email.setText(t1);
        address.setText(t2);
        user_id.setText(String.valueOf(t4));
       details_id.setText(String.valueOf(t3));
    }
}


