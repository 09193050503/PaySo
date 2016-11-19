package com.berstek.payso.fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.berstek.payso.R;
import com.berstek.payso.activities.MainActivity;
import com.berstek.payso.model.AppStatus;
import com.berstek.payso.model.SetupTempData;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetupConfirmationFragment extends Fragment {


    public SetupConfirmationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_setup_confirmation, container, false);
        populateFields(view);
        listenToConfirmB(view);
        listenToResetB(view);
        return view;
    }

    private SetupTempData setupTempData;

    public void setSetupTempData(SetupTempData setupTempData) {
        this.setupTempData = setupTempData;
    }

    private void populateFields(View view) {
        TextView symbol = (TextView)view.findViewById(R.id.txt_current_symbol);
        TextView cycle = (TextView)view.findViewById(R.id.txt_current_cycle);
        TextView dailyBudget = (TextView)view.findViewById(R.id.txt_daily_budget);

        symbol.setText(setupTempData.getCurrency() + " - " + setupTempData.getSymbol());
        cycle.setText("Starts every " + setupTempData.getCycleStart());
        dailyBudget.setText("Daily: "  + computeBudget());
    }

    private DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private String computeBudget() {
        return setupTempData.getSymbol() + " " +
                decimalFormat.format(setupTempData.getBudget() / setupTempData.getDivisor());
    }

    private void listenToConfirmB(final View view) {
        Button button = (Button)view.findViewById(R.id.btn_confirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppStatus.setSetupDone(true);
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void listenToResetB(final View view) {
        Button button = (Button)view.findViewById(R.id.btn_reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CurrencySelectionFragment fragment = new CurrencySelectionFragment();
                FragmentManager fn = getFragmentManager();
                FragmentTransaction ft = fn.beginTransaction();
                ft.replace(R.id.fragment_setup_fragment, fragment);
                ft.commit();
            }
        });
    }
}
