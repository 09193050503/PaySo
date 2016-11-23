package com.berstek.payso.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.payso.R;
import com.berstek.payso.adapters.TransactionSelectionAdapter;
import com.berstek.payso.model.TransactionSelectionData;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTransactionFragment extends Fragment {


    public AddTransactionFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private TransactionSelectionAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_transaction, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recview_transactions_selection);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);

        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new TransactionSelectionAdapter(TransactionSelectionData.getData(), getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

}
