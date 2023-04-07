package com.example.tooneactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;





import android.view.View;


import android.content.Intent;

import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;
    UserDao userDao;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession daoSession= ((MyApplication) getApplication()).getDaoSession();
        userDao = daoSession.getUserDao();


        final RecyclerView rvItems= findViewById(R.id.recyclerView);

        userList = userDao.queryBuilder().list();
        Toast.makeText(this,"Length = "+userList.size(),Toast.LENGTH_LONG).show();



        UserAdapter todoItemAdapter=new UserAdapter(userList);
        rvItems.setAdapter(todoItemAdapter);

        rvItems.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        btn = findViewById(R.id.addbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, UserActivity.class));

            }
        });
    }
}