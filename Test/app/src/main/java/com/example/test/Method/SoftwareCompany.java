package com.example.test.Method;

import android.content.Context;

import com.example.test.Interface.IDesigner;
import com.example.test.Interface.IDeveloper;

import javax.inject.Inject;

public class SoftwareCompany {

    @Inject
     PSD designer;
    @Inject
     AndroidDeveloper developer;

    @Inject
    public SoftwareCompany(Context context, PSD designer, AndroidDeveloper developer) {
        this.designer = designer;
        this.developer = developer;
    }

    public void createApp() {
        developer.developIt();
    }
}
