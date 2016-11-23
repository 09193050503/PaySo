package com.berstek.payso.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.berstek.payso.R;
import com.berstek.payso.model.RecentActivitiesItem;
import com.berstek.payso.model.TransactionSelectionItem;

import java.util.List;

import static android.R.attr.type;


/**
 * Created by John on 11/13/2016.
 */

public class TransactionSelectionAdapter extends RecyclerView.Adapter<TransactionSelectionAdapter.ListHolder>{

    private List listData;
    private LayoutInflater inflater;
    private Context context;

    public TransactionSelectionAdapter(List<TransactionSelectionItem> listData, Context context) {
        this.listData = listData;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_transaction_selection, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        TransactionSelectionItem listItem = (TransactionSelectionItem) listData.get(position);
        holder.details.setText(listItem.getDetails());
        holder.transactionIcon.setImageResource(context.getResources().getIdentifier(listItem.getImageUrl(), null, context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return listData.size() ;
    }


    class ListHolder extends RecyclerView.ViewHolder {

        private TextView details;
        private ImageView transactionIcon;
        private View container;

        public ListHolder(View itemView) {
            super(itemView);

            details = (TextView)itemView.findViewById(R.id.txt_details);
            transactionIcon = (ImageView)itemView.findViewById(R.id.img_transaction_icon);
        }
    }
}
