package com.mxuan.musicclock;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wangwenxuan on 2017/3/19.
 */

public class MusicService extends Service{

    public final MusicBind binder = new MusicBind();

    public MediaPlayer mediaPlayer;

    @Override
    public void onCreate(){
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        binder.setMediaPlayer(mediaPlayer);
        Log.d("MusicServic", "service create success");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
