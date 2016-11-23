package com.berstek.payso.fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.berstek.payso.R;
import com.berstek.payso.model.AppSettings;
import com.berstek.payso.model.CycleData;
import com.berstek.payso.utils.CycleUtils;

import java.text.DecimalFormat;
import java.util.Date;

import static android.R.attr.data;

/**
 * A simple {@link Fragment} subclass.
 */
public class CashManagementFragment extends Fragment {


    public CashManagementFragment() {
        // Required empty public constructor
    }

    private DecimalFormat d = new DecimalFormat("0.00");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_cash_management, container, false);

        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        TextView dailyRemaining = (TextView)view.findViewById(R.id.txt_daily_remaining);
        TextView spendingOverAllowance = (TextView)view.findViewById(R.id.txt_spending_over_allowance);

        AppSettings settings = new AppSettings(view.getContext());
        CycleData cycleData = new CycleData(view.getContext());

        double totalDailySpending = cycleData.getDailyTotalSpending(),
                dailyAllowance = cycleData.getDailyBudget(),
                remainingDailyAllowance = dailyAllowance - totalDailySpending;

        spendingOverAllowance.setText(d.format(totalDailySpending) + "\nof\n" + d.format(dailyAllowance));
        dailyRemaining.setText(settings.getSymbol() + " " + d.format(remainingDailyAllowance));

        progressBar.setProgress((int)(totalDailySpending / dailyAllowance));

        listenToFAB(view);

        /*
        cycleData.loadData();
        dailyRemaining.setText(Double.toString(cycleData.getBudget()));
         */


//        AppSettings appSettings = new AppSettings(view.getContext());


       // dailyRemaining.setText(Double.toString(appSettings.getBudget()));

        return view;
    }

    private void listenToFAB(View view){
        final FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTransactionFragment fragment = new AddTransactionFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_lower_screen, fragment);
                fragmentTransaction.commit();
                fab.setVisibility(View.INVISIBLE);
            }
        });
    }

}
