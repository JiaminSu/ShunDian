package com.lanou.entity;

/**
 * Created by lanou on 2017/12/4.
 */
public class All_Left {
    private Integer all_id;

    private Integer left_id;

    public Integer getAll_id() {
        return all_id;
    }

    public Integer getLeft_id() {
        return left_id;
    }

    public void setAll_id(Integer all_id) {
        this.all_id = all_id;
    }

    public void setLeft_id(Integer left_id) {
        this.left_id = left_id;
    }

    @Override
    public String toString() {
        return "All_Left{" +
                "all_id=" + all_id +
                ", left_id=" + left_id +
                '}';
    }

    public All_Left() {
        super();
    }

    public All_Left(Integer all_id, Integer left_id) {
        this.all_id = all_id;
        this.left_id = left_id;
    }
}

