package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeChatActivity extends AppCompatActivity {

    private ImageView ivSetting, ivFoto;
    private TextView tvFirstChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_chat);

        ivSetting = findViewById(R.id.setting);
        ivFoto = findViewById(R.id.foto);
        tvFirstChat = findViewById(R.id.firstchat);

        ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent(HomeChatActivity.this, SettingActivity.class);
                startActivity(setting);
            }
        });

        tvFirstChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat = new Intent( HomeChatActivity.this, ChatActivity.class);
                startActivity(chat);
            }
        });

        ivFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat = new Intent( HomeChatActivity.this, ChatActivity.class);
                startActivity(chat);
            }
        });

    }
}