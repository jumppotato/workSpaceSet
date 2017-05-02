package com.mxuan.musicclock;

import android.media.MediaPlayer;
import android.os.Binder;
import android.util.Log;

import java.io.IOException;

/**
 * Created by wangwenxuan on 2017/3/19.
 */

public class MusicBind extends Binder {

    private MediaPlayer mediaPlayer;

    private String musicUrl;

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void setMusic(String musicUrl){
        if(this.musicUrl != null && this.musicUrl.equals(musicUrl)) {
            playOrPause();
            return;
        }
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(musicUrl);
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
            Log.d("MusicBind", "setMusic success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.musicUrl = musicUrl;
    }

    public void playOrPause(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            Log.d("MusicBind", "pause");
        }else{
            mediaPlayer.start();
            Log.d("MusicBind", "play");
        }
    }
}
