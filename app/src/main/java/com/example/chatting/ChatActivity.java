package com.example.chatting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;
    private LinearLayoutManager mLinearLayoutManager;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intentReceived = getIntent();
        title=findViewById(R.id.title);
        title.setText(intentReceived.getExtras().getString("Title"));


        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("doha2","첫번째 메시지"));

        contactsRecView = findViewById(R.id.contactRecView);
        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);
        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new LinearLayoutManager(this));
        mLinearLayoutManager = new LinearLayoutManager(this);
        contactsRecView.setLayoutManager(mLinearLayoutManager);



        EditTextV2 editText = findViewById(R.id.editText);
        Button submit = findViewById(R.id.submit);
        ImageButton goBack = findViewById(R.id.goBack);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((editText.getText().toString()).equals("")){
                    Toast.makeText(ChatActivity.this, "empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    contacts.add(new Contact("doha",editText.getText().toString()));
                    mLinearLayoutManager.scrollToPosition(contacts.size() - 1);
                }
                editText.setText("");

            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this,AllChatActivity.class);
                startActivity(intent);
            }
        });
    }

    public static class EditTextV2 extends androidx.appcompat.widget.AppCompatEditText
    {
        public EditTextV2( Context context )
        {
            super( context );
        }

        public EditTextV2( Context context, AttributeSet attribute_set )
        {
            super( context, attribute_set );
        }

        public EditTextV2( Context context, AttributeSet attribute_set, int def_style_attribute )
        {
            super( context, attribute_set, def_style_attribute );
        }

        @Override
        public boolean onKeyPreIme( int key_code, KeyEvent event )
        {
            if ( key_code == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP )
                this.clearFocus();

            return super.onKeyPreIme( key_code, event );
        }
    }

}
