package com.wm.myapplicationea;

import static com.wm.myapplicationea.utils.Constants.LOGIN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wm.myapplicationea.dto.LoginDto;
import com.wm.myapplicationea.dto.RegistrationDto;


public class RegestrationActivity extends AppCompatActivity {
    private RegistrationDto reg;

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
                reg = new RegistrationDto(login.getText().toString(), pwd.getText().toString(), pwd2.getText().toString());
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
                reg = new RegistrationDto(login.getText().toString(), pwd.getText().toString(), pwd2.getText().toString());
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
                reg = new RegistrationDto(login.getText().toString(), pwd.getText().toString(), pwd2.getText().toString());
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
            //String loginValue = login.getText().toString();
            //String pwdValue = pwd.getText().toString();
            //String pwd2Value = pwd2.getText().toString();
            boolean equalsPwd2 = reg.getHaslo2().equals(reg.getHaslo());

            boolean isLoginEmpty = reg.getLogin().isEmpty();
            updateComponent(login, isLoginEmpty ? "Podaj login" : "", isLoginEmpty ? Color.RED : Color.WHITE);
            boolean isPwdEmpty = reg.getHaslo().isEmpty();
            updateComponent(pwd, isPwdEmpty ? "Podaj hasło" : "", isPwdEmpty ? Color.RED : Color.WHITE);
            boolean isPwd2Empty = reg.getHaslo2().isEmpty();
            updateComponent(pwd2, isPwd2Empty ? "Powtórz hasło" : "", isPwd2Empty ? Color.RED : Color.WHITE);

            //Intent intentRegestration = new Intent(this, MainActivity.class);
            //intentRegestration.putExtra("login", getLogin);
            //intentRegestration.putExtra("password", getHaslo);
            if (!reg.isHasloEquals()){
                pwd2.setText("");
                updateComponent(pwd2, "Powtórzone hasło nie jest identyczne", Color.RED);
            } else if (reg.hasFieldsFilled()) {
                LoginDto loginDto = new LoginDto(reg.getLogin(), reg.getHaslo());
                Intent intentRegestration = new Intent(this, MainActivity.class);
                intentRegestration.putExtra(LOGIN, loginDto);
                startActivity(intentRegestration);
            }
        });
    }
/*
    String registrationDTO = login.getText().toString();
    RegistrationDto reg = RegistrationDTO();
    reg RegistrationDTO().build();
    reg =
*/
    public void updateComponent(EditText et, String text, int color) {
        et.setHint(text);
        et.setBackgroundColor(color);
    }
}