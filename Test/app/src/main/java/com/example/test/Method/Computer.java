package com.example.test.Method;

import android.util.Log;

import javax.inject.Inject;

public class Computer {

    @Inject
    public Computer() {
    }

    private static final String TAG = "Computer";
    public void start(){
        Log.d(TAG, "start: ");
    }
}
