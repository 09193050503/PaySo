package com.berstek.payso.model;

import android.support.annotation.DrawableRes;

/**
 * Created by John on 11/15/2016.
 */

public class RecentActivitiesItem {

    private String type, cost;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}