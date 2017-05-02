package com.mxuan.musicclock.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.mxuan.musicclock.MusicBind;
import com.mxuan.musicclock.MusicService;
import com.mxuan.musicclock.R;
import com.mxuan.musicclock.SongAdapter;
import com.mxuan.musicclock.music.Song;
import com.mxuan.musicclock.tools.AudioUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @ViewById
    ListView listView;

    private SongAdapter songAdapter;

    private MusicBind musicBind;

    @AfterViews
    public void afterViews(){
        refreshMusic();

        ArrayList<Song> songList = AudioUtils.getAllSongs(getApplicationContext());
        listView.setAdapter(songAdapter = new SongAdapter(this, R.layout.item_song, songList));

        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                musicBind = (MusicBind) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    private void refreshMusic() {
        MediaScannerConnection.scanFile(this, new String[] { Environment
                .getExternalStorageDirectory().getAbsolutePath() }, null, null);
    }

    @ItemClick
    public void listViewItemClicked(int position){
        Song song = songAdapter.getItem(position);
        musicBind.setMusic(song.getFileUrl());
        Log.d("MainActivity", song.getFileName());
    }
}
