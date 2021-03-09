package com.example.test.Method;

import android.util.Log;

import javax.inject.Inject;

public class AndroidStudio {

    @Inject
    public AndroidStudio() {
    }

    private static final String TAG = "AndroidStudio";
    public void start(){
        Log.d(TAG, "start: ");
    }
}
