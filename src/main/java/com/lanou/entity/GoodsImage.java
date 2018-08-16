package com.lanou.entity;

/**
 * Created by lanou on 2017/12/5.
 */
public class GoodsImage {

    private Integer ImageId;
    private String imageUrl;
    private Integer Goods_id;
    private Integer Type;

    public Integer getImageId() {
        return ImageId;
    }

    public void setImageId(Integer imageId) {
        ImageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getGoods_id() {
        return Goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        Goods_id = goods_id;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public GoodsImage() {
        super();
    }

    @Override
    public String toString() {
        return "GoodsImage{" +
                "ImageId=" + ImageId +
                ", imageUrl='" + imageUrl + '\'' +
                ", Goods_id=" + Goods_id +
                ", Type=" + Type +
                '}';
    }
}
