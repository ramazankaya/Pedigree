package com.example.test.Companent;

import android.app.Application;

import androidx.fragment.app.Fragment;

import com.example.test.Method.ApplicationModule;
import com.example.test.Method.SoftwareCompany;
import com.example.test.Module.SoftwareCompanyModule;
import com.example.test.UI.FragmnetActivity;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponent {

    void inject(Fragment mainActivity);

//    @Component.Builder
//    interface Builder {
//
//        @BindsInstance
//        Builder application(Application application);
//
//        AppComponent build();
//    }
}
