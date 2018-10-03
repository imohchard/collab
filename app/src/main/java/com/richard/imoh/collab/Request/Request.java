package com.richard.imoh.collab.Request;

/**
 * Created by LENOVO on 8/4/2018.
 */

public class Request {
    String description;
    String price;
    String state;
    String city;
    String isUrgent;
    //Property type being either flat, self contain as in the case of residential or office space in the case of commercial
    String propertyType;
    //Let type being rent, lease or sell
    String letType;
    int size;
    //resRoomNo being residence, room number
    int resRoomNo;
    String agentName;
    String agentDp;
    String userId;
    String requestTime;
    String reqId;


    public Request() {
    }

    public Request(String description, String price, String state, String city, String isUrgent, String propertyType, String letType, int size, int resRoomNo, String agentName, String agentDp, String userId, String requestTime, String reqId) {
        this.description = description;
        this.price = price;
        this.state = state;
        this.city = city;
        this.isUrgent = isUrgent;
        this.propertyType = propertyType;
        this.letType = letType;
        this.size = size;
        this.resRoomNo = resRoomNo;
        this.agentName = agentName;
        this.agentDp = agentDp;
        this.userId = userId;
        this.requestTime = requestTime;
        this.reqId = reqId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrgent() {
        return isUrgent;
    }

    public void setUrgent(String urgent) {
        isUrgent = urgent;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getLetType() {
        return letType;
    }

    public void setLetType(String letType) {
        this.letType = letType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getResRoomNo() {
        return resRoomNo;
    }

    public void setResRoomNo(int resRoomNo) {
        this.resRoomNo = resRoomNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentDp() {
        return agentDp;
    }

    public void setAgentDp(String agentDp) {
        this.agentDp = agentDp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }
}
