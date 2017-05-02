package com.mxuan.musicclock;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.mxuan.musicclock.model.DaoMaster;
import com.mxuan.musicclock.model.DaoSession;

import org.androidannotations.annotations.EApplication;

/**
 * Created by wangwenxuan on 2017/3/18.
 */

@EApplication
public class MainApplication extends Application{
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public static MainApplication instances;
    @Override
    public void onCreate(){
        super.onCreate();

        helper = new DaoMaster.DevOpenHelper(this, "user-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

        instances = this;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static MainApplication getInstances() {
        return instances;
    }
}
