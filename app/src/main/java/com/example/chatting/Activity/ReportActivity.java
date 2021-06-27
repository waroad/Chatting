package com.example.chatting.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chatting.R;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Button btnSendReport = findViewById(R.id.btnSendReport);

        btnSendReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReportActivity.this, "신고 접수가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}