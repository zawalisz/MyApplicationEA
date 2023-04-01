package com.wm.myapplicationea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class RegestrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);

        setTitle("Rejestruj konto");
//        getWindow().getDecorView().setBackgroundColor(Color.CYAN);

        EditText login = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText pwd = (EditText) findViewById(R.id.editTextTextPassword2);
        EditText pwd2 = (EditText) findViewById(R.id.editTextTextPassword);

        Button registrationBut = (Button) findViewById(R.id.button3);

        login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean isLoginEmpty = login.getText().toString().isEmpty();
                if (hasFocus) {
                    updateComponent(login, "", Color.WHITE);
                } else {
                    updateComponent(login, isLoginEmpty ? "Podać login" : "", isLoginEmpty ? Color.RED : Color.WHITE);
                }
            }
        });

        pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean isPwdEmpty = pwd.getText().toString().isEmpty();
                if (hasFocus) {
                    updateComponent(pwd, "", Color.WHITE);
                } else {
                    updateComponent(pwd, isPwdEmpty ? "Podać hasło" : "", isPwdEmpty ? Color.RED : Color.WHITE);
                }
            }
        });

        pwd2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean isPwd2Empty = pwd2.getText().toString().isEmpty();
                String pwdval = pwd.getText().toString();
                String pwd2val = pwd2.getText().toString();
                if (hasFocus){
                    updateComponent(pwd2, "", Color.WHITE);
                } else {
                    updateComponent(pwd2, isPwd2Empty ? "Powtórz hasło" : "", isPwd2Empty ? Color.RED : Color.WHITE);
                }
                if (!pwd2val.isEmpty()) {
                    if (pwd2val.equals(pwdval)) {
                        updateComponent(pwd2, "", Color.WHITE);
                    } else {
                        pwd2.setText("");
                        updateComponent(pwd2, "Nieprawidłowe hasło", Color.RED);
                    }
                }
            }
        });

        registrationBut.setOnClickListener(view -> {
            String loginValue = login.getText().toString();
            String pwdValue = pwd.getText().toString();
            String pwd2Value = pwd2.getText().toString();
            boolean equalsPwd2 = pwd2Value.equals(pwdValue);

            boolean isLoginEmpty = loginValue.isEmpty();
            updateComponent(login, isLoginEmpty ? "Podaj login" : "", isLoginEmpty ? Color.RED : Color.WHITE);
            boolean isPwdEmpty = pwdValue.isEmpty();
            updateComponent(pwd, isPwdEmpty ? "Podaj hasło" : "", isPwdEmpty ? Color.RED : Color.WHITE);
            boolean isPwd2Empty = pwd2Value.isEmpty();
            updateComponent(pwd2, isPwd2Empty ? "Powtórz hasło" : "", isPwd2Empty ? Color.RED : Color.WHITE);

            Intent intentRegestration = new Intent(this, MainActivity.class);
            intentRegestration.putExtra("login", loginValue);
            intentRegestration.putExtra("password", pwdValue);
            if (!equalsPwd2){
                pwd2.setText("");
                updateComponent(pwd2, "Powtórzone hasło nie jest identyczne", Color.RED);
            } else if (pwdValue.isEmpty() && !loginValue.isEmpty() && !pwd2Value.isEmpty()) {
                startActivity(intentRegestration);
            }
        });
    }

    public void updateComponent(EditText et, String text, int color) {
        et.setHint(text);
        et.setBackgroundColor(color);
    }
}