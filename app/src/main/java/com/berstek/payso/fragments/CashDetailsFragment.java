package com.berstek.payso.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.payso.R;
import com.berstek.payso.adapters.RecentActivitiesAdapter;
import com.berstek.payso.model.RecentActivitiesData;

/**
 * A simple {@link Fragment} subclass.
 */
public class CashDetailsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecentActivitiesAdapter adapter;

    public CashDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cash_details, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recview_recent_activities);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecentActivitiesAdapter(RecentActivitiesData.getData(), getActivity());
        recyclerView.setAdapter(adapter);
        return view;
    }

}
