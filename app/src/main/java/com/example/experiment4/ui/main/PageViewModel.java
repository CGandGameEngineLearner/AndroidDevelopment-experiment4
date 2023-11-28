package com.example.experiment4.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.experiment4.R;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });

    private LiveData<Integer> mImageID=Transformations.map(mIndex, new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer input) {
            input=input-1;
            if(input>=mImageRes.length||input<0)
            {
                return 0;
            }
            return mImageRes[input];
        }
    });

    static private int mImageRes[]={R.mipmap.tab_1,R.mipmap.tab_2,R.mipmap.tab_2,R.mipmap.tab_2};

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<Integer> getImageID(){
        return mImageID;
    }
}