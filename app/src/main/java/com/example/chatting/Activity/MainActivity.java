package com.example.chatting.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chatting.R;

public class MainActivity extends AppCompatActivity {
    private Button btnChatList, btnMyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnChatList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllChatActivity.class);
                startActivity(intent);
            }
        });
        btnMyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyPageActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        btnChatList = findViewById(R.id.buttonC);
        btnMyPage = findViewById(R.id.buttonMyPage);
    }
}