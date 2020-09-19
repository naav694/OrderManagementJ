package com.devmaw.ordermanagementj.model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.devmaw.ordermanagementj.model.pojo.Customer;
import com.devmaw.ordermanagementj.model.pojo.Order;
import com.devmaw.ordermanagementj.model.pojo.User;

@Database(
        entities = {User.class, Order.class, Customer.class},
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract OrderDao orderDao();

    public abstract UserDao userDao();

    public abstract CustomerDao customerDao();

}
