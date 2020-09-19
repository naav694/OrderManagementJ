package com.devmaw.ordermanagementj.model.repository.implementation;

import com.devmaw.ordermanagementj.model.db.UserDao;
import com.devmaw.ordermanagementj.model.pojo.User;
import com.devmaw.ordermanagementj.model.repository.interfaces.IUserRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class UserRepository implements IUserRepository {

    private UserDao userDao;

    @Inject
    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Single<User> onLogin(String userName, String userPassword) {
        return userDao.getUser(userName, userPassword);
    }

    @Override
    public Single<Long> onSignin(User user) {
        return userDao.insert(user);
    }
}
