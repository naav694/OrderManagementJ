package com.devmaw.ordermanagementj.model.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.devmaw.ordermanagementj.model.pojo.User;

import io.reactivex.Single;


@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insert(User user);

    @Query("SELECT * FROM user WHERE userName = :userName AND userPassword = :userPassword")
    Single<User> getUser(String userName, String userPassword);
}
