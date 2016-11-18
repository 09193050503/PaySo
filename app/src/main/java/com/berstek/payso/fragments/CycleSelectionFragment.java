package com.berstek.payso.fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.berstek.payso.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CycleSelectionFragment extends Fragment {


    public CycleSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cycle_selection, container, false);
        TextView currentCurrencyText = (TextView)view.findViewById(R.id.txt_current_currency);
        currentCurrencyText.setText(message);
        listenToChangeCurrency(view);
        listenToRadio(view);
        return view;
    }

    private static String message = "";

    public static void setSymbol(String symbol) {
        CycleSelectionFragment.symbol = symbol;
    }

    private static String symbol;
    public void setMessage(String message) {
        this.message = message;
    }

    private void listenToChangeCurrency(View view) {
        CardView cardView = (CardView)view.findViewById(R.id.card_change_currency);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CurrencySelectionFragment();
                FragmentManager fn = getFragmentManager();
                FragmentTransaction ft = fn.beginTransaction();
                ft.replace(R.id.fragment_setup_fragment, fragment);
                ft.commit();
            }
        });
    }

    private void listenToRadio(View view) {
        RadioButton monthRB = (RadioButton)view.findViewById(R.id.radio_month);
        monthRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SelectDateFragment();
                FragmentManager fn = getFragmentManager();
                FragmentTransaction ft = fn.beginTransaction();
                ft.replace(R.id.fragment_setup_month, fragment);
                ft.commit();
            }
        });

        RadioButton weekRB = (RadioButton)view.findViewById(R.id.radio_week);
        weekRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDayFragment fragment = new SelectDayFragment();
                fragment.setSymbol(symbol);
                fragment.setCurrency(message);
                //fragment.setCurrency(message);
                FragmentManager fn = getFragmentManager();
                FragmentTransaction ft = fn.beginTransaction();
                ft.replace(R.id.fragment_setup_month, fragment);
                ft.commit();
            }
        });
    }
}
