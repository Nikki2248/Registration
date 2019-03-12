package com.example.rocket.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class UserListActivity extends AppCompatActivity {

TextView textView,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
t2 =(TextView)findViewById(R.id.t2);

        textView =(TextView)findViewById(R.id.t1);
        Intent intent = getIntent();
        String str = intent.getStringExtra("location");

        textView.setText(str);
        t2.setText(str);


    }


}
