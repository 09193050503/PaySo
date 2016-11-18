package com.berstek.payso.staticData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 11/17/2016.
 */

public class CurrenciesData {

    private static final String[] countries = {
            "Afghanistan",
            "Albania",
            "Algeria",
            "Angola",
            "Anguilla",
            "Antigua and Barbuda",
            "Argentina",
            "Philippines",
            "Afghanistan",
            "Albania",
            "Algeria",
            "Angola",
            "Anguilla",
            "Antigua and Barbuda",
            "Argentina",
            "Philippines"
    };

    private static final String[] currencies = {
            "Afghan afghani",
            "Albanian lek",
            "Algerian dinar",
            "Angolan kwanza",
            "East Caribbean dollar",
            "East Caribbean dollar",
            "Argentine peso",
            "Philippine Peso",
            "Afghan afghani",
            "Albanian lek",
            "Algerian dinar",
            "Angolan kwanza",
            "East Caribbean dollar",
            "East Caribbean dollar",
            "Argentine peso",
            "Philippine Peso"
    };

    private static final String[] isos = {
            "AFN",
            "ALL",
            "DZD",
            "AOA",
            "XCD",
            "XCD",
            "ARS",
            "PHP",
            "AFN",
            "ALL",
            "DZD",
            "AOA",
            "XCD",
            "XCD",
            "ARS",
            "PHP"
    };

    private static final String[] symbols = {
            "",
            "",
            "",
            "",
            "",
            "EC$",
            "EC$",
            "₱",
            "",
            "",
            "",
            "",
            "",
            "EC$",
            "EC$",
            "₱"
    };

    public static List<Currency> getData() {
        List<Currency> data = new ArrayList<>();

        for(int i = 0; i < countries.length; i++) {
            Currency item = new Currency();
            item.setCountry(countries[i]);

            if(symbols[i].equals("")) {
                item.setSymbol(isos[i]);
            }
            else {
                item.setSymbol(symbols[i]);
            }

            item.setCurrency(currencies[i]);
            item.setIso(isos[i]);
            data.add(item);
        }
        return data;
    }
}

