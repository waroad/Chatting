package com.example.chatting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyPageRecViewAdapter extends RecyclerView.Adapter<MyPageRecViewAdapter.ViewHolder> {

    private ArrayList<MyPageList> myPageList = new ArrayList<>();
    private Context context;

    public void setMyPageList(ArrayList<MyPageList> myPageList) {
        this.myPageList = myPageList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyPageRecViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mypage_list, parent, false);
        return new MyPageRecViewAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyPageRecViewAdapter.ViewHolder holder, int position) {
        holder.title.setText(myPageList.get(position).getTitle());

        if (!myPageList.get(position).isHasArrow()) {
            holder.title.setTextColor(Color.parseColor("#FF7979"));
        } else {
            Glide.with(context).asBitmap().load(R.drawable.ic_arrow).into(holder.arrowPic);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context, SuggestionsActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, SettingsActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, TermsActivity.class);
                        context.startActivity(intent);
                        break;
                    default:
                        intent = new Intent(context, ChatActivity.class);
                        intent.putExtra("Title3", holder.title.getText().toString());
                        context.startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myPageList.size();
    }

    public MyPageRecViewAdapter(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private CardView parent;
        private ImageView arrowPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            arrowPic = itemView.findViewById(R.id.arrowPic);
            title = itemView.findViewById(R.id.title);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
