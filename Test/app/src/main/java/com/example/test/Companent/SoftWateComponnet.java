package com.example.test.Companent;

import com.example.test.Method.SoftwareCompany;
import com.example.test.Module.SoftwareCompanyModule;
import com.example.test.NavFragment.BlankFragment;
import com.example.test.Scope.FragmentScope;

import javax.inject.Singleton;

import dagger.Component;

@FragmentScope
@Component(modules = {SoftwareCompanyModule.class})
public interface SoftWateComponnet {


//    SoftwareCompany getCompony();

    void inject(BlankFragment fragment);

}
