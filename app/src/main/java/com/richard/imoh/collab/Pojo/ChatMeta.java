package com.richard.imoh.collab.Pojo;

/**
 * Created by LENOVO on 7/5/2018.
 */

public class ChatMeta {
    String displayName;
    String lastMessage;
    String displayImg;
    String displayTime;
    String chatRef;
    int messageCount;
    String uId;


    public ChatMeta(String lastMessage, String displayTime, int messageCount, String uId) {
        this.lastMessage = lastMessage;
        this.displayTime = displayTime;
        this.messageCount = messageCount;
        this.uId = uId;

    }

    public ChatMeta() {
    }

    public ChatMeta(String displayName, String lastMessage, String displayImg, String displayTime, String chatRef, int messageCount,String uId) {
        this.displayName = displayName;
        this.lastMessage = lastMessage;
        this.displayImg = displayImg;
        this.displayTime = displayTime;
        this.chatRef = chatRef;
        this.messageCount = messageCount;
        this.uId = uId;
    }

    public String getChatRef() {
        return chatRef;
    }

    public void setChatRef(String chatRef) {
        this.chatRef = chatRef;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getDisplayImg() {
        return displayImg;
    }

    public void setDisplayImg(String displayImg) {
        this.displayImg = displayImg;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
