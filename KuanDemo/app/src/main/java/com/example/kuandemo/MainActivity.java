package com.example.kuandemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Icon> iconList= new ArrayList<>();

    private RecyclerView iconRecyclerView;

    private IconAdapter adapter;

    private EditText inputText;

    private View top;

    private Button enter;

    private Button hide;

    private Button tips;

    private Button about;

    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏标题栏
        ActionBar actionBar =getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        //加入活动管理器
        ActivityCollector.addActivity(this);
        //初始化数据
        initIcons();

        top = (View) findViewById(R.id.top_panel);
        inputText = (EditText) findViewById(R.id.top_edit);
        hide = (Button) findViewById(R.id.top_button_left);
        enter = (Button) findViewById(R.id.top_button_right);
        tips = (Button) findViewById(R.id.bottom_button_left);
        about = (Button) findViewById(R.id.bottom_button_center);
        exit = (Button) findViewById(R.id.bottom_button_right);
        iconRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //定义layoutmanager和adapter并应用于recyclerview
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        adapter = new IconAdapter(iconList);
        iconRecyclerView.setLayoutManager(layoutManager);
        iconRecyclerView.setAdapter(adapter);

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                top.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "隐藏panel", Toast.LENGTH_SHORT).show();
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = inputText.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("Data",data);
                startActivity(intent);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (top.getVisibility() == View.GONE){
                    top.setVisibility(View.VISIBLE);
                }
                Toast.makeText(MainActivity.this, "显示panel", Toast.LENGTH_SHORT).show();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Design by");
                dialog.setMessage("Lstaras");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    private void initIcons(){

        for (int i = 0; i < 2; i++) {
            Icon icon1 = new Icon(R.drawable.ic_action_achievement, "1");
            iconList.add(icon1);
            Icon icon2 = new Icon(R.drawable.ic_action_bike, "2");
            iconList.add(icon2);
            Icon icon3 = new Icon(R.drawable.ic_action_cancel, "3");
            iconList.add(icon3);
            Icon icon4 = new Icon(R.drawable.ic_action_undo, "4");
            iconList.add(icon4);
            Icon icon5 = new Icon(R.drawable.ic_action_trash, "5");
            iconList.add(icon5);
            Icon icon6 = new Icon(R.drawable.ic_action_process_save, "6");
            iconList.add(icon6);
            Icon icon7 = new Icon(R.drawable.ic_action_sort_1, "7");
            iconList.add(icon7);
            Icon icon8 = new Icon(R.drawable.ic_action_yinyang, "8");
            iconList.add(icon8);
            Icon icon9 = new Icon(R.drawable.ic_action_star_0, "9");
            iconList.add(icon9);
            Icon icon10 = new Icon(R.drawable.ic_action_warning, "10");
            iconList.add(icon10);
            Icon icon11 = new Icon(R.drawable.ic_action_ball, "11");
            iconList.add(icon11);
            Icon icon12 = new Icon(R.drawable.ic_action_clock, "12");
            iconList.add(icon12);
        }
    }
}
