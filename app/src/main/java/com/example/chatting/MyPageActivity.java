package com.example.chatting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyPageActivity extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;
    private ImageButton chooseImage;
    private ImageView profileImage;
    private RecyclerView myPageRecView;
    private MyPageRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        initViews();
        adapter = new MyPageRecViewAdapter(this);
        myPageRecView=findViewById(R.id.myPageRecView);
        myPageRecView.setAdapter(adapter);
        myPageRecView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<MyPageList> myPageList = new ArrayList<>();
        myPageList.add(new MyPageList("건의사항 보내기",true));
        adapter.setMyPageList(myPageList);
        myPageList.add(new MyPageList("설정",true));
        myPageList.add(new MyPageList("서비스 이용약관",true));
        myPageList.add(new MyPageList("로그아웃",false));


        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PICK_IMAGE);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            //TODO: action
            Uri imageUri = data.getData();

        }
    }
    private void initViews(){
        chooseImage=findViewById(R.id.chooseImage);
        profileImage=findViewById(R.id.profileImage);
        Glide.with(this).asBitmap().load(R.drawable.ic_default_profile_img).into(this.profileImage);
    }
}