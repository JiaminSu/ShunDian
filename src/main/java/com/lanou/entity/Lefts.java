package com.lanou.entity;

/**
 * Created by lanou on 2017/12/4.
 */
public class Lefts {
    private Integer leftId;
    private String leftName;

    public Integer getLeftId() {
        return leftId;
    }

    public void setLeftId(Integer leftId) {
        this.leftId = leftId;
    }

    public String getLeftName() {
        return leftName;
    }

    public void setLeftName(String leftName) {
        this.leftName = leftName;
    }

    @Override
    public String toString() {
        return "Left{" +
                "leftId=" + leftId +
                ", leftName='" + leftName + '\'' +
                '}';
    }

    public Lefts() {
        super();
    }

    public Lefts(Integer leftId, String leftName) {
        this.leftId = leftId;
        this.leftName = leftName;
    }
}
