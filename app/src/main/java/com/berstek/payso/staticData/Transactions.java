package com.berstek.payso.staticData;

/**
 * Created by John on 11/22/2016.
 */

public class Transactions {

    public static final String getImageUrl(String str) {
        switch (str.toLowerCase()) {
            case "food": return "@drawable/ic_food";
            case "clothe": return "@drawable/ic_clothe";
            case "education": return "@drawable/ic_education";
            case "gift": return "@drawable/ic_gift";
            case "grocery": return "@drawable/ic_grocery";
            case "gym": return "@drawable/ic_gym";
            case "medical": return "@drawable/ic_medical";
            default: return "@drawable/ic_others";
        }
    }
}
