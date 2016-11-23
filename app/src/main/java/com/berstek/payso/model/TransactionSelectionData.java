package com.berstek.payso.model;

import com.berstek.payso.staticData.Transactions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 11/22/2016.
 */

public class TransactionSelectionData {

    private static final String[] transactions = {
            "Food",
            "Water",
            "Clothe",
            "Gym",
            "Gift",
            "Grocery",
            "Medical",
            "Education",
            "Food",
            "Water",
            "Clothe",
            "Gym",
            "Gift",
            "Grocery",
            "Medical",
            "Education",
            "Food",
            "Water",
            "Clothe",
            "Gym",
            "Gift",
            "Grocery",
            "Medical",
            "Education"
    };

    public static List<TransactionSelectionItem> getData() {
        List<TransactionSelectionItem> data = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {
            TransactionSelectionItem item = new TransactionSelectionItem();
            item.setImageUrl(Transactions.getImageUrl(transactions[i]));
            item.setDetails(transactions[i]);
            data.add(item);
        }
        return data;
    }
}
