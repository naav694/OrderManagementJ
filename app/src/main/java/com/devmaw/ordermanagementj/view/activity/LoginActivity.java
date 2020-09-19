package com.devmaw.ordermanagementj.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.devmaw.ordermanagementj.R;
import com.devmaw.ordermanagementj.databinding.ActivityLoginBinding;
import com.devmaw.ordermanagementj.model.pojo.User;
import com.devmaw.ordermanagementj.viewmodel.LoginViewModel;
import com.devmaw.ordermanagementj.di.ViewModelProviderFactory;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

    @Inject
    ViewModelProviderFactory providerFactory;

    private LoginViewModel loginViewModel;

    private TextInputEditText editLoginPassword;
    private TextInputEditText editLoginUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this, providerFactory).get(LoginViewModel.class);
        setContentView(R.layout.activity_login);
        /*ActivityLoginBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_login
        );
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);*/
        initComponents();
        subscribeObservers();
    }

    private void initComponents() {
        Button btnLogin = findViewById(R.id.btnLogin);
        editLoginUser = findViewById(R.id.editLoginUser);
        editLoginPassword = findViewById(R.id.editLoginPassword);
        CheckBox loginCheckRemember = findViewById(R.id.loginCheckRemember);
        TextView textSignIng = findViewById(R.id.textSignIng);

        btnLogin.setOnClickListener(v -> {
            if (editLoginUser.getText() != null && editLoginPassword.getText() != null) {
                loginViewModel.onLogin(
                        editLoginUser.getText().toString(),
                        editLoginPassword.getText().toString()
                );
            }
        });

        textSignIng.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    private void subscribeObservers() {
        loginViewModel.user.observe(this, user -> {
            if (user != null) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                Toast.makeText(this, "User not found!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginViewModel.onDestroy();
    }

}