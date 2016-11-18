package com.berstek.payso.fragments;


import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.app.Fragment;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.berstek.payso.R;

import java.text.DecimalFormat;

import static android.R.attr.filter;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnterBudgetFragment extends Fragment {

    public EnterBudgetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_budget, container, false);
        loadPassedData(view);
        listenToBudgetType(view);
        return view;
    }

    private String currency = "";

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    private String symbol = "";
    private String cycle = "";
    private int divisor = 1;

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    private void loadPassedData(View view) {
        TextView currentCurrency = (TextView)view.findViewById(R.id.txt_current_currency);
        currentCurrency.setText(currency);
        TextView currentCycle = (TextView)view.findViewById(R.id.txt_current_cycle);
        currentCycle.setText(cycle);


    }

    private void listenToBudgetType (final View view){
        final TextView estimatedBudget = (TextView)view.findViewById(R.id.txt_estimated_budget);

        final EditText editText = (EditText)view.findViewById(R.id.tf_enter_budget);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                estimatedBudget.setText(estimate(editText.getText().toString()));

                return false;
            }
        });
    }

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private String estimate(String budget) {
        double b = 0;
        try {
            b = Double.parseDouble(budget);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return "Daily Budget: " +  symbol + " " + decimalFormat.format(b / divisor);
    }

}
