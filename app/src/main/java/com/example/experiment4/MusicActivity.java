package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

class MusicBean{
    public String mMusicName;
    public int mMusicResID;
}


public class MusicActivity extends AppCompatActivity {

    private final Button mButtonPlay=findViewById(R.id.buttonPlay),
    mButtonPause=findViewById(R.id.buttonPause),
    mButtonStop=findViewById(R.id.buttonStop),
    mButtonNext=findViewById(R.id.buttonNext);

    private final ListView mListView=findViewById(R.id.listView);

    private void initButtons()
    {

    }
    private ArrayList<MusicBean> mMusicArray;
    private void loadListView()
    {
        ArrayAdapter<MusicBean> adapter = new ArrayAdapter<MusicBean>(this, R.layout.music_list_item, mMusicArray);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initButtons();
    }
}
