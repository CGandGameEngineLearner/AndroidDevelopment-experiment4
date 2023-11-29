package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;
import com.example.experiment4.MusicBean;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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

    private TextView textViewMusicName,textViewSingerName,textViewLyric;

    private void init()
    {
        textViewMusicName=findViewById(R.id.textViewMusicName);
        textViewSingerName=findViewById(R.id.textViewSingerName);
        textViewLyric=findViewById(R.id.textViewLyric);

        textViewMusicName.setText(mMusicBean.mMusicName);
        textViewSingerName.setText(mMusicBean.mSingerName);
        textViewLyric.setText(mMusicBean.mLyric);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);
        mMusicBean=getMusicBean();
        init();
    }
}
