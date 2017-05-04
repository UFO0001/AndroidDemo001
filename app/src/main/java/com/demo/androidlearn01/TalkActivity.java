package com.demo.androidlearn01;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class TalkActivity extends Activity {

    private List<Talk> talkList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView talkRecyclerView;
    private TalkAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);
        initTalk();
        inputText = (EditText) findViewById(R.id.talk_input_text);
        send = (Button) findViewById(R.id.talk_send);
        talkRecyclerView = (RecyclerView) findViewById(R.id.talk_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        talkRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new TalkAdapter(talkList);
        talkRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Talk talk = new Talk(content,Talk.TYPE_SENT);
                    talkList.add(talk);
                    adapter.notifyItemInserted(talkList.size()-1);
                    talkRecyclerView.scrollToPosition(talkList.size()-1);
                    inputText.setText("");
                }
            }
        });
    }

    private void initTalk() {
        Talk talk1 = new Talk("Hello boy,I am a girl!",Talk.TYPE_RECEIVED);
        Talk talk2 = new Talk("Hello girl,I am a Man!",Talk.TYPE_SENT);
        Talk talk3 = new Talk("Nice to meet you!",Talk.TYPE_RECEIVED);
        Talk talk4 = new Talk("Nice to meet you too!",Talk.TYPE_SENT);
        Talk talk5 = new Talk("What's your name?",Talk.TYPE_RECEIVED);
        Talk talk6 = new Talk("My name is YINGYING,and you?",Talk.TYPE_SENT);
        Talk talk7 = new Talk("I am RUANRUAN",Talk.TYPE_RECEIVED);
        Talk talk8 = new Talk("HaHaHa,I Love You!",Talk.TYPE_SENT);
        talkList.add(talk1);
        talkList.add(talk2);
        talkList.add(talk3);
        talkList.add(talk4);
        talkList.add(talk5);
        talkList.add(talk6);
        talkList.add(talk7);
        talkList.add(talk8);
    }
}
