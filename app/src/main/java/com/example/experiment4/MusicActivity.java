package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
        mMediaPlayer.stop();
        mMediaPlayer.release();
        mMediaPlayer=MediaPlayer.create(this, musicBean.mMusicResID);
        mMediaPlayer.start();
    }

    public void playNextMusic()
    {
        playMusic((mCurrentMusicIndex+1)%mMusicBeans.size());
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
    private ArrayList<String> mMusicNames=new ArrayList<String>();
    private ArrayList<MusicBean> mMusicBeans=new ArrayList<MusicBean>();
    private void loadListView()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.music_list_item, mMusicNames);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent IntentDetail=new Intent(MusicActivity.this,MusicDetailActivity.class);
                MusicBean musicBean=mMusicBeans.get(position);
                IntentDetail.putExtra("MusicName",musicBean.mMusicName);
                IntentDetail.putExtra("MusicResID",musicBean.mMusicResID);
                IntentDetail.putExtra("SingerName",musicBean.mSingerName);
                IntentDetail.putExtra("Lyric",musicBean.mLyric);
                startActivity(IntentDetail);
            }
        });
    }

    private void loadMusicAsset()
    {
        // 在这里自定义你想要添加的歌
        // 歌曲音频文件放到res/raw目录下，没有这个目录就创建个
        // 按这个格式依葫芦画瓢自定义你自己想要的歌曲
        MusicBean[] musicBeans={
                new MusicBean("说好不哭",R.raw.shuo_hao_bu_ku,"周杰伦","歌词"),
                new MusicBean("moos",R.raw.moss,"歌手","歌词")
        };
        for(MusicBean musicBean:musicBeans)
        {
            Log.d("Music",musicBean.mMusicName);
            mMusicNames.add(musicBean.mMusicName);
            mMusicBeans.add(musicBean);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initButtons();
        mListView=findViewById(R.id.listView);
        loadMusicAsset();
        loadListView();
    }
}
