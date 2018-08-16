package com.lanou.entity;

/**
 * Created by lanou on 2017/12/4.
 */
public class Rights {
    private Integer left_id;
    private Integer right_id;
    private String  right_name;

    public Integer getLeft_id() {
        return left_id;
    }

    public void setLeft_id(Integer left_id) {
        this.left_id = left_id;
    }

    public Integer getRight_id() {
        return right_id;
    }

    public void setRight_id(Integer right_id) {
        this.right_id = right_id;
    }

    public String getRight_name() {
        return right_name;
    }

    public void setRight_name(String right_name) {
        this.right_name = right_name;
    }

    @Override
    public String toString() {
        return "Rights{" +
                "left_id=" + left_id +
                ", right_id=" + right_id +
                ", right_name='" + right_name + '\'' +
                '}';
    }

    public Rights() {
        super();
    }

    public Rights(Integer left_id, Integer right_id, String right_name) {
        this.left_id = left_id;
        this.right_id = right_id;
        this.right_name = right_name;
    }
}
