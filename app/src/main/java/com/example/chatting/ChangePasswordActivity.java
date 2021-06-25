package com.example.chatting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {

    Button submit;
    ImageButton goBack;
    TextView password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        password1=(TextView)findViewById(R.id.password1);
        password2=(TextView)findViewById(R.id.password2);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password1.getText().toString().equals(password2.getText().toString())) {
                    Toast.makeText(ChangePasswordActivity.this, "비밀번호 변경 완료", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(ChangePasswordActivity.this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        goBack=findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}