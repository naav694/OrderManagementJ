package com.devmaw.ordermanagementj.viewmodel;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {
    public CompositeDisposable mDisposable = new CompositeDisposable();

    public abstract void onDestroy();
}
