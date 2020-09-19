package com.devmaw.ordermanagementj.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmaw.ordermanagementj.model.pojo.User;
import com.devmaw.ordermanagementj.model.repository.implementation.UserRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterViewModel extends BaseViewModel {

    @Inject
    UserRepository userRepository;

    private CompositeDisposable mDisposable = new CompositeDisposable();

    private MutableLiveData<Long> _idUser = new MutableLiveData<>();
    public final LiveData<Long> idUser = _idUser;


    @Inject
    public RegisterViewModel() {

    }

    public void onCreateUser(User user) {
        mDisposable.add(userRepository.onSignin(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(result -> _idUser.setValue(result)
                        , throwable -> {
                            if (throwable.getMessage() != null)
                                Log.e("REGISTER", throwable.getMessage());
                        }
                )
        );
    }

    @Override
    public void onDestroy() {
        mDisposable.clear();
    }
}
