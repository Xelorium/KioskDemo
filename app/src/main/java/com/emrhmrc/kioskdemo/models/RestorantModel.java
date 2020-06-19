package com.emrhmrc.kioskdemo.models;

import com.emrhmrc.genericrecycler.models.BaseModel;

/**
 * Created by hamurcuabi on 18,June,2020
 **/
public class RestorantModel extends BaseModel {
    private int id;
    private String name;
    private String image;
    private boolean isSelected;
    private int orderIndex;

    public RestorantModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }
}
