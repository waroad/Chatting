package com.example.chatting.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.chatting.R;

public class SettingsActivity extends AppCompatActivity {
    private TextView changeNickname, changePassword;
    private ImageButton goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initViews();

        changeNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ChangeNicknameActivity.class);
                startActivity(intent);
            }
        });
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initViews() {
        changeNickname = (TextView) findViewById(R.id.changeNickname);
        changePassword = (TextView) findViewById(R.id.changePassword);
        goBack = findViewById(R.id.goBack);
    }
}