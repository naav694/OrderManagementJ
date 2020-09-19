package com.devmaw.ordermanagementj.model.pojo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int idUser;
    private String fullName;
    private String userName;
    private String userPassword;

    @NotNull
    @Override
    public String toString() {
        return String.format("%s %s %s", fullName, userName, userPassword);
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
