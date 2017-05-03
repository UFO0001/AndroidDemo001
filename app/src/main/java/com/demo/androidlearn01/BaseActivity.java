package com.demo.androidlearn01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by THF on 17/5/3.
 */

public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver receiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);//加入活动类
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);//移除
    }
    /**
     *     因为我们始终要保证只有处于栈顶的活动才能接收到此强制下线广播，非栈顶的活动不应该也没有必要接收此广播
     *     写在onResume onPause 方法里就可以很好的解决这个问题
     *     当一个活动失去栈顶位置时就会自动取消广播接收器的注册
     */

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.demo.androidlearn01.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);//注册广播
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(receiver != null){
            unregisterReceiver(receiver);//Activity 生命周期进行到 onpause 时 取消注册
            receiver = null;
        }
    }

    class ForceOfflineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("warning");
            builder.setMessage("You are forced to be offline ! Please try again later.");
            builder.setCancelable(false);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();//销毁所有活动
                    //或在这里Intent
//                    Intent intent = new Intent(context,MainActivity.class);
//                    context.startActivity(intent);//启动指定的Activity
                }
            });
            builder.show();
        }
    }
}
