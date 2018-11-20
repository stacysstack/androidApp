package com.example.csci5115_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.List;


public class PurchaseHistoryAdapter extends RecyclerView.Adapter<PurchaseHistoryAdapter.PurchaseHistoryViewHolder> {

    static int mExpandedPosition = -1;

    public View popview;

    Button reorderButton;
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<PurchaseHistoryItem> phList;

    //getting the context and product list with constructor
    public PurchaseHistoryAdapter(Context mCtx, List<PurchaseHistoryItem> phList) {
        this.mCtx = mCtx;
        this.phList = phList;
    }

    @Override
    public PurchaseHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_purchase_history_items, null);
        return new PurchaseHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PurchaseHistoryViewHolder holder, final int position) {
        System.out.println(position);
        PurchaseHistoryItem phItem = phList.get(position);
        final boolean isExpanded = position==mExpandedPosition;
        holder.expandable.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.expandable.setActivated(isExpanded);
        System.out.println("setting expanded");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(position);
                reorderButton = (Button) v.findViewById(R.id.phReorder);
                reorderButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent orderPopup = new Intent(mCtx,activity_confirmorder.class);
                        mCtx.startActivity(orderPopup);
                    }
                });
            }
        });

        holder.phAc.setText(phItem.getAccount());
        holder.phDate1.setText(phItem.getDate());
        holder.phDate2.setText(phItem.getDate());
        holder.phOrder.setText(phItem.getOrder());
        holder.phPrice.setText(phItem.getPrice());
        holder.phRest1.setText(phItem.getRestaurantName());
        holder.phRest2.setText(phItem.getRestaurantName());
        holder.phTotal.setText(phItem.getTotal());

    }


    @Override
    public int getItemCount() {
        return phList.size();
    }


    class PurchaseHistoryViewHolder extends RecyclerView.ViewHolder {

        View expandable;
        TextView phAc, phDate1, phDate2, phOrder, phPrice, phRest1, phRest2, phTotal;

        public PurchaseHistoryViewHolder(View itemView) {
            super(itemView);

            this.expandable = itemView.findViewById(R.id.phItemExpandedArea);
            this.phAc = itemView.findViewById(R.id.phAc);
            this.phDate1 = itemView.findViewById(R.id.phDate1);
            this.phDate2 = itemView.findViewById(R.id.phDate2);
            this.phOrder = itemView.findViewById(R.id.phOrder);
            this.phPrice = itemView.findViewById(R.id.phPrice);
            this.phRest1 = itemView.findViewById(R.id.phRest1);
            this.phRest2 = itemView.findViewById(R.id.phRest2);
            this.phTotal = itemView.findViewById(R.id.phTotal);

        }
    }
}
