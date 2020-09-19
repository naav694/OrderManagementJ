package com.devmaw.ordermanagementj.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.devmaw.ordermanagementj.R;
import com.devmaw.ordermanagementj.model.pojo.User;
import com.devmaw.ordermanagementj.viewmodel.RegisterViewModel;
import com.devmaw.ordermanagementj.di.ViewModelProviderFactory;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

public class RegisterActivity extends BaseActivity {

    @Inject
    ViewModelProviderFactory providerFactory;

    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerViewModel = new ViewModelProvider(this, providerFactory).get(RegisterViewModel.class);
        setContentView(R.layout.activity_register);
        /*ActivityRegisterBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_register
        );
        binding.setLifecycleOwner(this);
        binding.setRegisterViewModel(registerViewModel);*/
        initComponents();
        subscribeObservers();
    }

    private void initComponents() {
        final TextInputEditText editFullName = findViewById(R.id.editFullName);
        final TextInputEditText editUserName = findViewById(R.id.editUserName);
        final TextInputEditText editUserPass = findViewById(R.id.editUserPass);
        Button btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setOnClickListener(v -> {
            if (editFullName.getText() != null && editUserName.getText() != null && editUserPass.getText() != null) {
                User user = new User();
                user.setFullName(editFullName.getText().toString());
                user.setUserName(editUserName.getText().toString());
                user.setUserPassword(editUserPass.getText().toString());
                registerViewModel.onCreateUser(user);
            }
        });
    }

    private void subscribeObservers() {
        registerViewModel.idUser.observe(this, aLong -> {
            if(aLong != null && aLong > 0) {
                Toast.makeText(this, "User created successfully!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Unknown error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerViewModel.onDestroy();
    }
}