package com.berstek.payso.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.berstek.payso.R;
import com.berstek.payso.adapters.RecentActivitiesAdapter;
import com.berstek.payso.model.AppSettings;
import com.berstek.payso.model.CycleData;
import com.berstek.payso.model.RecentActivitiesData;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class CashDetailsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecentActivitiesAdapter adapter;

    public CashDetailsFragment() {
        // Required empty public constructor
    }

    DecimalFormat d = new DecimalFormat("0.00");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cash_details, container, false);

        CycleData cycleData = new CycleData(view.getContext());
        AppSettings settings = new AppSettings(view.getContext());

        TextView totalBudgetTxt = (TextView)view.findViewById(R.id.txt_total_budget);
        totalBudgetTxt.setText(settings.getSymbol() + d.format(cycleData.getTotalBudget() - cycleData.getTotalSpendings()));

        TextView estimatedSavingsTxt = (TextView)view.findViewById(R.id.txt_estimated_savings);
        estimatedSavingsTxt.setText(settings.getSymbol() + d.format(cycleData.getEstimatedSavings()));

        TextView dailyTotalExpense = (TextView)view.findViewById(R.id.txt_total_daily_expenses);
        dailyTotalExpense.setText(settings.getSymbol() + d.format(cycleData.getDailyTotalSpending()));


        recyclerView = (RecyclerView)view.findViewById(R.id.recview_recent_activities);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecentActivitiesAdapter(RecentActivitiesData.getData(), getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }

}
