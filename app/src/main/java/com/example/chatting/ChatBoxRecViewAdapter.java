package com.example.chatting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatBoxRecViewAdapter extends RecyclerView.Adapter<ChatBoxRecViewAdapter.ViewHolder> {

    private ArrayList<ChatBox> chatBoxes = new ArrayList<>();

    private Context context;

    public ChatBoxRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other_chat, parent, false);
        ViewHolder holder = new ViewHolder(view);
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_chat, parent, false);
        ViewHolder holder2 = new ViewHolder(view2);

        if (viewType == 0) {
            return holder;
        }
        return holder2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.txtName.setText(contacts.get(position).getName());
        holder.text.setText(chatBoxes.get(position).getText());
        holder.time.setText(chatBoxes.get(position).getTime());
        holder.user.setText(chatBoxes.get(position).getName());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, chatBoxes.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return chatBoxes.size();
    }

    public void setContacts(ArrayList<ChatBox> chatBoxes) {
        this.chatBoxes = chatBoxes;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView user, text, time;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user);
            time = itemView.findViewById(R.id.time);
            text = itemView.findViewById(R.id.text);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
