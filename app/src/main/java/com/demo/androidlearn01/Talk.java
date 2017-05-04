package com.demo.androidlearn01;

/**
 * Created by THF on 17/5/4.
 * 消息实体类
 */

public class Talk {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;//表示消息内容
    private int type;//表示消息类型
    public Talk(String content, int type){
        this.content = content;
        this.type = type;
    }
    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
}
