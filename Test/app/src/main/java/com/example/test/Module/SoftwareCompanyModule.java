package com.example.test.Module;

import android.app.Application;
import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.test.Interface.IDesigner;
import com.example.test.Interface.IDeveloper;
import com.example.test.Method.AndroidDeveloper;
import com.example.test.Method.AndroidStudio;
import com.example.test.Method.Computer;
import com.example.test.Method.PSD;
import com.example.test.Method.SoftwareCompany;
import com.example.test.Scope.FragmentScope;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module()
//@Module
public class SoftwareCompanyModule {



    private Context context;

    public SoftwareCompanyModule(Context context) {
        this.context = context;
    }

    @FragmentScope
    @Provides
    SoftwareCompany provideSoftwareCompany(@Named("application_context") Context context, PSD designer, AndroidDeveloper developer) {
        return new SoftwareCompany(context, designer, developer);
    }

    @FragmentScope
    @Provides
    AndroidDeveloper getDeveloper(AndroidStudio androidStudio, Computer computer) {
        return new AndroidDeveloper(computer, androidStudio);
    }

    @FragmentScope
    @Provides
    Computer getComputer() {
        return new Computer();
    }

    @FragmentScope
    @Provides
    AndroidStudio getAndroidStudio() {
        return new AndroidStudio();
    }

    @FragmentScope
    @Provides
    PSD getPSd() {
        return new PSD();
    }


    @Named("application_context")
    @FragmentScope
    @Provides
    Context getContext() {
        return context;
    }


}
