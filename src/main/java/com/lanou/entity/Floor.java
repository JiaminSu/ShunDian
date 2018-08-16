package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
public class Floor {

    private Integer floorId;
    private String floorName;
    private List<FloorImage> floorImages;

    public List<FloorImage> getFloorImages() {
        return floorImages;
    }

    public void setFloorImages(List<FloorImage> floorImages) {
        this.floorImages = floorImages;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + floorId +
                ", floorName='" + floorName + '\'' +
                ", floorImages=" + floorImages +
                '}';
    }

    public Floor() {
        super();
    }
}
