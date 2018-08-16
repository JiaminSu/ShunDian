package com.lanou.entity;

/**
 * Created by lanou on 2017/12/6.
 */
public class Comments {

    private Integer cId;
    private Integer goods_id;
    private Integer user_id;
    private String content;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comments() {
        super();
    }

    @Override
    public String toString() {
        return "Comments{" +
                "cId=" + cId +
                ", goods_id=" + goods_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                '}';
    }
}
