package com.example.tooneactivity;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import java.util.jar.Attributes;

public class MyApplication extends Application {
    private DaoSession daoSession;
    User user;


    @Override
    public void onCreate(){
        super.onCreate();

        //regular SQLite Database
        DaoMaster.DevOpenHelper helper= new DaoMaster.DevOpenHelper(this,"Tooneactivity",null);
        Database db=helper.getWritableDb();

        daoSession = new DaoMaster(db).newSession();

    }



    public DaoSession getDaoSession(){
        return daoSession;
    }
}
