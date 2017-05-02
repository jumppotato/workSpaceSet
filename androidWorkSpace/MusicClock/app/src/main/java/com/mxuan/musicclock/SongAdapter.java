package com.mxuan.musicclock;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mxuan.musicclock.music.Song;

import java.util.List;

/**
 * Created by wangwenxuan on 2017/3/18.
 */

public class SongAdapter extends ArrayAdapter<Song>{

    private final LayoutInflater inflater;

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Song song = getItem(position);
        convertView = inflater.inflate(R.layout.item_song, parent, false);
        TextView textview = (TextView) convertView.findViewById(R.id.songName);
        textview.setText(song.getFileName() + ":" + song.getFileUrl());
        return convertView;
    }

}
