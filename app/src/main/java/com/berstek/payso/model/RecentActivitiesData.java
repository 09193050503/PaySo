package com.berstek.payso.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by John on 11/15/2016.
 */

public class RecentActivitiesData {

    private static final String[] types = {
            "Food",
            "Clothe",
            "Transportation",
            "Education",
            "Phone Load",
            "Water",
    };

    private static final String[] details = {
            "McDo",
            "Nike",
            "MRT",
            "NEU Tuition",
            "Smart Load",
            "Nawasa",
    };

    private static final String[] costs = {
            "- ₱150",
            "- ₱500",
            "- ₱50",
            "- ₱20",
            "- ₱30",
            "- ₱1500"
    };

    private static String getImageUrl(String str) {
        if(str.equalsIgnoreCase("food"))
            return "@drawable/ic_food";
        else if (str.equalsIgnoreCase("clothe"))
            return "@drawable/ic_clothe";
        else if (str.equalsIgnoreCase("transportation"))
            return "@drawable/ic_transpo";
        else if (str.equalsIgnoreCase("clothe"))
            return "@drawable/ic_clothe";
        else if (str.equalsIgnoreCase("education"))
            return "@drawable/ic_education";
        else
            return "@drawable/ic_launcher";

    }

    public static List<RecentActivitiesItem> getData() {
        List<RecentActivitiesItem> data = new ArrayList<>();

        for(int i = 0; i < types.length; i++) {
            RecentActivitiesItem item = new RecentActivitiesItem();
            item.setType(types[i]);
            item.setCost(costs[i]);
            item.setDetails(details[i]);
            item.setImageUrl(getImageUrl(item.getType()));
            data.add(item);
        }
        return data;
    }
}
