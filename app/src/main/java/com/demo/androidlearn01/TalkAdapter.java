package com.demo.androidlearn01;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by THF on 17/5/4.
 */

public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.ViewHolder>{

    private List<Talk> mTalkList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout,rightLayout;
        TextView leftTalk,rightTalk;
        public ViewHolder(View view){
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.talk_item_left_layout);
            rightLayout = (LinearLayout) view.findViewById(R.id.talk_item_right_layout);
            leftTalk = (TextView) view.findViewById(R.id.talk_item_left_msg);
            rightTalk = (TextView) view.findViewById(R.id.talk_item_right_msg);
        }
    }
    public TalkAdapter(List<Talk> talkList){
        mTalkList = talkList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.talk_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Talk talk = mTalkList.get(position);
        if(talk.getType() == Talk.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftTalk.setText(talk.getContent());
        }else if(talk.getType() == Talk.TYPE_SENT){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightTalk.setText(talk.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mTalkList.size();
    }
}
