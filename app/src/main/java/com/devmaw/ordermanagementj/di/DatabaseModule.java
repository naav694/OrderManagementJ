package com.devmaw.ordermanagementj.di;

import android.app.Application;

import androidx.room.Room;

import com.devmaw.ordermanagementj.model.db.AppDatabase;
import com.devmaw.ordermanagementj.model.db.CustomerDao;
import com.devmaw.ordermanagementj.model.db.OrderDao;
import com.devmaw.ordermanagementj.model.db.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Singleton
    @Provides
    static AppDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, "ordermanagement")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    static UserDao provideUserDao(Application application) {
        return provideDatabase(application).userDao();
    }

    @Singleton
    @Provides
    static OrderDao provideOrderDao(Application application) {
        return provideDatabase(application).orderDao();
    }

    @Singleton
    @Provides
    static CustomerDao provideCustomerDao(Application application) {
        return provideDatabase(application).customerDao();
    }

}
