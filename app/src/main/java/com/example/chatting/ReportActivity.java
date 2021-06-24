package com.example.chatting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


        ImageButton sendReport = findViewById(R.id.sendReport);

        sendReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReportActivity.this, "신고 접수가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ReportActivity.this,AllChatActivity.class);
                startActivity(intent);
            }
        });
    }
}