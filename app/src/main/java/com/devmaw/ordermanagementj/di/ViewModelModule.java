package com.devmaw.ordermanagementj.di;

import androidx.lifecycle.ViewModel;

import com.devmaw.ordermanagementj.viewmodel.LoginViewModel;
import com.devmaw.ordermanagementj.viewmodel.RegisterViewModel;
import com.devmaw.ordermanagementj.viewmodel.SplashViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    public abstract ViewModel bindSplashViewModel(SplashViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel.class)
    public abstract ViewModel bindRegisterViewModel(RegisterViewModel viewModel);


}
