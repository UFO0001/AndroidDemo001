package com.demo.androidlearn01;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 *
 * 用于强制下线，如检测到用户密码等改变 关闭所有活动跳转到登录页面
 * 用于完全退出程序
 */
public class Fragmentout extends Fragment {

    private Button btn_out;

    public Fragmentout() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmentout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_out = (Button) getActivity().findViewById(R.id.btn_out);
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.demo.androidlearn01.FORCE_OFFLINE");
                getActivity().sendBroadcast(intent);
            }
        });
    }
}
