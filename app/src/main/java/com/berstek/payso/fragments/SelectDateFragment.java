package com.berstek.payso.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.payso.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectDateFragment extends Fragment {


    public SelectDateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_date, container, false);
    }

}
