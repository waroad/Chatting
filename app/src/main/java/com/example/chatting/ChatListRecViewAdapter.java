package com.example.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ChatListRecViewAdapter extends RecyclerView.Adapter<ChatListRecViewAdapter.ViewHolder> {

    private ArrayList<ChatList> chatList = new ArrayList<>();
    private Context context;
    public void setChatList(ArrayList<ChatList> chatList) {
        this.chatList = chatList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ChatListRecViewAdapter.ViewHolder holder, int position) {
        holder.title.setText(chatList.get(position).getTitle());
        holder.userNum.setText(chatList.get(position).getUserNum());
        Glide.with(context).asBitmap().load(R.drawable.ic_launcher_foreground).into(holder.humanPic);
        Glide.with(context).asBitmap().load(R.drawable.ic_baseline_chat_24).into(holder.chatPic);
        if(chatList.get(position).isNewMessage())Glide.with(context).asBitmap().load(R.drawable.ic_baseline_chat_24_2).into(holder.chatPic);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, chatList.get(position).getTitle()+" selected", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,ChatActivity.class);
                intent.putExtra("Title",holder.title.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public ChatListRecViewAdapter(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userNum, title;
        private CardView parent;
        private ImageView humanPic, chatPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userNum = itemView.findViewById(R.id.userNum);
            humanPic= itemView.findViewById(R.id.humanPic);
            chatPic= itemView.findViewById(R.id.chatPic);
            title = itemView.findViewById(R.id.title);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
