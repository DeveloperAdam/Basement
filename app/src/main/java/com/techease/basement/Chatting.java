package com.techease.basement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Chatting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Chatting.this,MyInbox.class);
        startActivity(intent);
        finish();
    }
}
