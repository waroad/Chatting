package com.example.chatting;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllChatActivity extends AppCompatActivity {
    private RecyclerView chatRecView;
    private ChatListRecViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_chats);
        adapter = new ChatListRecViewAdapter(this);
        chatRecView = findViewById(R.id.allChatRecView);
        chatRecView.setAdapter(adapter);
        chatRecView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<ChatList> chatList = new ArrayList<>();
        chatList.add(new ChatList("크누마켓 전체 채팅방", 214, true));
        chatList.add(new ChatList("공차 먹을 사람", 2, false));
        chatList.add(new ChatList("덮덮밥 같이 시켜요", 3, false));
        adapter.setChatList(chatList);
    }
}
