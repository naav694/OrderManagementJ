package com.devmaw.ordermanagementj.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmaw.ordermanagementj.model.pojo.User;
import com.devmaw.ordermanagementj.model.repository.implementation.UserRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel {

    private final MutableLiveData<User> _user = new MutableLiveData<>();
    public final LiveData<User> user = _user;

    private final MutableLiveData<Boolean> _loginForm = new MutableLiveData<>();
    public final LiveData<Boolean> loginForm = _loginForm;

    @Inject
    UserRepository userRepository;

    @Inject
    public LoginViewModel() {

    }

    public void onLogin(String userName, String userPassword) {
        if (isLoginValid()) {
            mDisposable.add(
                    userRepository.onLogin(userName, userPassword)
                            //.doOnSubscribe(result -> _loginForm.setValue(false))
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(_user::setValue, throwable -> {
                                if (throwable.getMessage() != null)
                                    Log.e("LOGIN", throwable.getMessage());
                            }));
        } else {
            _loginForm.setValue(false);
        }
    }

    private Boolean isLoginValid() {
        return true;
    }

    @Override
    public void onDestroy() {
        mDisposable.clear();
    }
}
