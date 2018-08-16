package com.lanou.entity;

/**
 * Created by lanou on 2017/12/4.
 */
public class FloorImage {

    private Integer fId;
    private String fUrl;
    private Integer floor_id;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfUrl() {
        return fUrl;
    }

    public void setfUrl(String fUrl) {
        this.fUrl = fUrl;
    }

    public Integer getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(Integer floor_id) {
        this.floor_id = floor_id;
    }

    public FloorImage() {

        super();

    }

    public FloorImage(Integer fId, String fUrl, Integer floor_id) {
        this.fId = fId;
        this.fUrl = fUrl;
        this.floor_id = floor_id;
    }

    @Override
    public String toString() {
        return "FloorImage{" +
                "fId=" + fId +
                ", fUrl='" + fUrl + '\'' +
                ", floor_id=" + floor_id +
                '}';
    }
}
