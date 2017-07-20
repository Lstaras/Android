package com.example.kuandemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActivityCollector.addActivity(this);

        TextView textView = (TextView) findViewById(R.id.text2);

        Intent intent = getIntent();
        String data = intent.getStringExtra("Data");
        textView.setText(data);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
