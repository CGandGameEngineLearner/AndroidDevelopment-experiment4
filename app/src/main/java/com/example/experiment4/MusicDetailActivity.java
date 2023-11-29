package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;
import com.example.experiment4.MusicBean;
import android.content.Intent;
import android.os.Bundle;

public class MusicDetailActivity extends AppCompatActivity {

    private MusicBean getMusicBean()
    {
        final Intent intent=getIntent();
        String MusicName=intent.getStringExtra("MusicName");
        int MusicResID=intent.getIntExtra("MusicResID",0);
        String SingerName=intent.getStringExtra("SingerName");
        String Lyric=intent.getStringExtra("Lyric");
        return new MusicBean(MusicName,MusicResID,SingerName,Lyric);
    }

    private MusicBean mMusicBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        mMusicBean=getMusicBean();
    }
}
