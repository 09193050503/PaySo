package com.berstek.payso.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.berstek.payso.R;
import com.berstek.payso.model.AppSettings;
import com.berstek.payso.utils.CycleUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class CashManagementFragment extends Fragment {


    public CashManagementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_cash_management, container, false);
        TextView dailyRemaining = (TextView)view.findViewById(R.id.txt_daily_remaining);
//        AppSettings appSettings = new AppSettings(view.getContext());


       // dailyRemaining.setText(Double.toString(appSettings.getBudget()));

        return view;
    }

}
