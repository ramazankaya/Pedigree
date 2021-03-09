package com.example.test.Method;

import com.example.test.Interface.IDeveloper;

import javax.inject.Inject;

public class AndroidDeveloper {
    @Inject
    Computer computer;
    @Inject
    AndroidStudio studio;

    @Inject
    public AndroidDeveloper(Computer computer, AndroidStudio studio) {
        this.computer = computer;
        this.studio = studio;
    }

    public void developIt() {
        computer.start();
        studio.start();
    }
}