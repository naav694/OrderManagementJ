package com.devmaw.ordermanagementj.view.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.devmaw.ordermanagementj.R;
import com.devmaw.ordermanagementj.viewmodel.SplashViewModel;
import com.devmaw.ordermanagementj.di.ViewModelProviderFactory;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

    @Inject
    Drawable companyLogo;
    @Inject
    RequestManager requestManager;
    @Inject
    ViewModelProviderFactory providerFactory;

    private SplashViewModel splashViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashViewModel = new ViewModelProvider(this, providerFactory).get(SplashViewModel.class);
        setContentView(R.layout.activity_splash);
        setLogo();
    }

    private void setLogo() {
        requestManager.load(companyLogo).into((ImageView) findViewById(R.id.imageSplash));
    }
}