package com.devmaw.ordermanagementj.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class SplashViewModel extends ViewModel {

    @Inject
    public SplashViewModel() {
        Log.d("SplashViewModel","viewmodel is working....");
    }


}
