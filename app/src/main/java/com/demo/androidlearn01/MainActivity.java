package com.demo.androidlearn01;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private Button btn_pic,btn_talk,btn_notice,btn_04,btn_01,btn_06,btn_07,btn_closeall;
    public static Fragment[] fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setFragment();
    }

    private void initView() {

        btn_01       = (Button) findViewById(R.id.btn_01);
        btn_04       = (Button) findViewById(R.id.btn_04);
        btn_06       = (Button) findViewById(R.id.btn_06);
        btn_07       = (Button) findViewById(R.id.btn_07);
        btn_pic      = (Button) findViewById(R.id.btn_pic);
        btn_talk     = (Button) findViewById(R.id.btn_talk);
        btn_notice   = (Button) findViewById(R.id.btn_notice);
        btn_closeall = (Button) findViewById(R.id.btn_closeall);

        btn_01.setOnClickListener(this);
        btn_04.setOnClickListener(this);
        btn_06.setOnClickListener(this);
        btn_07.setOnClickListener(this);
        btn_pic.setOnClickListener(this);
        btn_talk.setOnClickListener(this);
        btn_notice.setOnClickListener(this);
        btn_closeall.setOnClickListener(this);

    }

    private void setFragment() {
        fragments = new Fragment[8];
        fragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment_01);
        fragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment_notice);
        fragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment_Pic);
        fragments[3] = getSupportFragmentManager().findFragmentById(R.id.fragment_04);
        fragments[4] = getSupportFragmentManager().findFragmentById(R.id.fragment_talk);
        fragments[5] = getSupportFragmentManager().findFragmentById(R.id.fragment_06);
        fragments[6] = getSupportFragmentManager().findFragmentById(R.id.fragment_07);
        fragments[7] = getSupportFragmentManager().findFragmentById(R.id.fragment_out);
        getSupportFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).hide(fragments[4]).hide(fragments[5]).hide(fragments[6]).hide(fragments[7]).show(fragments[0]).commit();
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_01:
                    Toast.makeText(MainActivity.this,"点我了01",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).hide(fragments[4]).hide(fragments[5]).hide(fragments[6]).hide(fragments[7]).show(fragments[0]).commit();
                    break;
                case R.id.btn_04:
                    Toast.makeText(MainActivity.this,"点我了04",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2]).hide(fragments[4]).hide(fragments[5]).hide(fragments[6]).hide(fragments[7]).show(fragments[3]).commit();
                    break;
                case R.id.btn_06:
                    Toast.makeText(MainActivity.this,"点我了06",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).hide(fragments[4]).hide(fragments[0]).hide(fragments[6]).hide(fragments[7]).show(fragments[5]).commit();
                    break;
                case R.id.btn_07:
                    Toast.makeText(MainActivity.this,"点我了07",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).hide(fragments[4]).hide(fragments[5]).hide(fragments[0]).hide(fragments[7]).show(fragments[6]).commit();
                    break;
                case R.id.btn_pic:
                    Toast.makeText(MainActivity.this,"点我了pic",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[0]).hide(fragments[3]).hide(fragments[4]).hide(fragments[5]).hide(fragments[6]).hide(fragments[7]).show(fragments[2]).commit();
                    break;
                case R.id.btn_talk:
                    Toast.makeText(MainActivity.this,"点我了talk",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).hide(fragments[0]).hide(fragments[5]).hide(fragments[6]).hide(fragments[7]).show(fragments[4]).commit();
                    break;
                case R.id.btn_notice:
                    Log.d("notice","001");
                    Toast.makeText(MainActivity.this,"点我了notice",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[2]).hide(fragments[3]).hide(fragments[4]).hide(fragments[5]).hide(fragments[6]).hide(fragments[7]).show(fragments[1]).commit();
                    break;
                case R.id.btn_closeall:
                    Toast.makeText(MainActivity.this,"点我了closeall",Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction().hide(fragments[1]).hide(fragments[2]).hide(fragments[3]).hide(fragments[4]).hide(fragments[5]).hide(fragments[6]).hide(fragments[0]).show(fragments[7]).commit();
                    break;
                default:
                    break;
            }
    }




}
