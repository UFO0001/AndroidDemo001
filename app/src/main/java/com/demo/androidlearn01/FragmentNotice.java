package com.demo.androidlearn01;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;


/**
 * 无论哪里创建通知，整体的步骤都是相同的。
 * 首先，需要一个NotificationMananger 来对通知进行管理
 *      可以调用Context的getSystemService()方法获取到
 *      getSystemService()方法接收一个字符串参数用于确定获取系统的哪个服务
 *      这里我们传入 Context.NOTIFICATION_SERVICE即可
 */
public class FragmentNotice extends Fragment {



    private Button btn_fragment_notice;
    public FragmentNotice() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_notice, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_fragment_notice = (Button) getActivity().findViewById(R.id.btn_fragment_notice);
        btn_fragment_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取NotificationManager实例
                NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                //使用一个Builder构造器创建Notification对象  有个需要注意的点:API的不稳定性的解决——>使用support库中提供的兼容API
                //support-v4 库提供了一个NotificationCompat类 用这个构造器创建 Notification 对象
                //创建一个空的Notification对象并进行基本的设置
                Intent intent = new Intent(getActivity(),NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getActivity(),0,intent,0);

                Notification  notification = new NotificationCompat.Builder(getContext())
                        .setContentTitle("通知的标题，下拉系统状态栏可以看到这部分内容")
                        //.setContentText("正文内容，下拉也可以看到")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  爱爱  "))//显示长文本全部显示
                        .setWhen(System.currentTimeMillis())//设置时间，毫秒为单位，下拉时指定的时间便会显示
                        .setSmallIcon(R.mipmap.ic_launcher)//小图标显示在系统状态栏上
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))//下拉时看到大图标
                        .setContentIntent(pi)//设置点击事件
                        .setPriority(NotificationCompat.PRIORITY_MAX)//设置重要程度
                        //.setDefaults(NotificationCompat.DEFAULT_ALL)//默认声音 灯光设置
                        //.setLights(Color.WHITE,2000,2000)//LED灯  颜色  亮起的时长 熄灭的时长
                        //.setVibrate(new long[]{0,100,1000,100})//设置震动 这里数值的意思是 通知来了立刻震动一秒 然后静止一秒 再震动一秒 注意需添加权限：
                        //.setSound(Uri.fromFile(new File("/system/media/audio/..."))) 设置声音
                        //.setAutoCancel(true)//取消通知显示的两种方法的一种 第二种在点击通知后的Activity里面填写
                        .build();
                /**
                 * 上面完成后 只需调用NotificationManager的notify()方法就可以让通知显示出来
                 * notify()接受两个参数：
                 *                      (1)  id  要保证每个通知的所指定的id都是不同的
                 *                      (2)  Notification对象  这里将我们刚刚创建好的Notification对象传入即可
                 * 显示通知就可写成 manager.notify(1,notification);
                 */

                manager.notify(1,notification);

                //通知一般就会点击 这里用到PendingIntent
            }
        });
    }
}
