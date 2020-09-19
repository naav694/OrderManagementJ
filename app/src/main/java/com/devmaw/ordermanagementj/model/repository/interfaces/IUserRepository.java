package com.devmaw.ordermanagementj.model.repository.interfaces;

import com.devmaw.ordermanagementj.model.pojo.User;

import io.reactivex.Single;

public interface IUserRepository {

    Single<User> onLogin(String userName, String userPassword);
    Single<Long> onSignin(User user);

}
