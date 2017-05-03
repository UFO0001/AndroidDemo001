package com.demo.androidlearn01;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotificationActivity extends BaseActivity {
    private TextView tv_notificationtomain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1);//通知指定的id

        tv_notificationtomain = (TextView) findViewById(R.id.tv_notificationtomain);
        tv_notificationtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.demo.androidlearn01.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
