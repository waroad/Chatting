package com.example.chatting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeNicknameActivity extends AppCompatActivity {
    Button submit;
    ImageButton goBack;
    TextView newNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_nickname);

        submit = findViewById(R.id.submit);
        newNickname = findViewById(R.id.newNickname);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newNickname.getText().toString().length() >= 2) {
                    Toast.makeText(ChangeNicknameActivity.this, "닉네임 변경 완료", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ChangeNicknameActivity.this, "닉네임은 2자 이상이어야 합니다.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}