package com.devmaw.ordermanagementj.di;

import com.devmaw.ordermanagementj.view.activity.LoginActivity;
import com.devmaw.ordermanagementj.view.activity.RegisterActivity;
import com.devmaw.ordermanagementj.view.activity.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();

    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivity();

    @ContributesAndroidInjector
    abstract RegisterActivity contributeRegisterActivity();


}
