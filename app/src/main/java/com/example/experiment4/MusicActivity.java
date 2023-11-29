package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

class MusicBean{
    public String mMusicName;
    public int mMusicResID;
    public String mSingerName;
    public String mLyric;

    public MusicBean(String MusicName,int MusicResID,String SingerName,String Lyric)
    {
        mMusicName=MusicName;
        mMusicResID=MusicResID;
        mSingerName=SingerName;
        mLyric=Lyric;
    }
}


public class MusicActivity extends AppCompatActivity {

    private  Button mButtonPlay,
    mButtonPause,
    mButtonStop,
    mButtonNext;

    private ListView mListView;
    private  MediaPlayer mMediaPlayer=new MediaPlayer();
    private int mCurrentMusicIndex=0;

    public void playMusic(int MusicIndex)
    {
        mCurrentMusicIndex=MusicIndex;
        MusicBean musicBean=mMusicBeans.get(MusicIndex);
        mMediaPlayer=MediaPlayer.create(this, musicBean.mMusicResID);
        mMediaPlayer.start();
    }

    public void playNextMusic()
    {
        playMusic(mCurrentMusicIndex%mMusicBeans.size());
    }

    public void stopMusic()
    {
        mMediaPlayer.stop();
    }
    public void pauseMusic()
    {
        mMediaPlayer.pause();
    }


    private void initButtons()
    {
        mButtonPlay=findViewById(R.id.buttonPlay);
        mButtonPause=findViewById(R.id.buttonPause);
        mButtonStop=findViewById(R.id.buttonStop);
        mButtonNext=findViewById(R.id.buttonNext);
        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(mCurrentMusicIndex);
            }
        });

        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseMusic();
            }
        });

        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMusic();
            }
        });
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNextMusic();
            }
        });
    }
    private ArrayList<String> mMusicNames;
    private ArrayList<MusicBean> mMusicBeans;
    private void loadListView()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.music_list_item, mMusicNames);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent IntentDetail=new Intent(MusicActivity.this,MusicDetailActivity.class);
                MusicBean musicBean=mMusicBeans.get(position-1);
                IntentDetail.putExtra("MusicName",musicBean.mMusicName);
                IntentDetail.putExtra("MusicResID",musicBean.mMusicResID);
                IntentDetail.putExtra("SingerName",musicBean.mSingerName);
                IntentDetail.putExtra("Lyric",musicBean.mLyric);
                startActivity(IntentDetail);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initButtons();
        mListView=findViewById(R.id.listView);
    }
}
