package com.example.csci5115_project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;


public class PurchaseHistoryAdapter extends RecyclerView.Adapter<PurchaseHistoryAdapter.PurchaseHistoryViewHolder> {

    static int mExpandedPosition = -1;


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
    public void onBindViewHolder(PurchaseHistoryViewHolder holder, final int position) {
        System.out.println(position);
        final boolean isExpanded = position==mExpandedPosition;
        holder.expandable.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.expandable.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("setting expanded");
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(position);
            }
        });
        //getting the PurchaseHistoryItem of the specified position
        PurchaseHistoryItem phItem = phList.get(position);

        //binding the data with the viewholder views
        //System.out.println(phItem.getDate());
        //System.out.println(phItem.getRestaurantName());
        //System.out.println(phItem.getPrice());

        holder.textViewDate.setText(phItem.getDate());
        holder.textViewRestaurant.setText(phItem.getRestaurantName());
        holder.textViewPrice.setText(phItem.getPrice());
    }


    @Override
    public int getItemCount() {
        return phList.size();
    }


    class PurchaseHistoryViewHolder extends RecyclerView.ViewHolder {

        View expandable;
        TextView textViewDate, textViewRestaurant, textViewPrice;

        public PurchaseHistoryViewHolder(View itemView) {
            super(itemView);

            this.expandable = itemView.findViewById(R.id.phItemExpandedArea);
            this.textViewDate = itemView.findViewById(R.id.textViewDate);
            this.textViewRestaurant = itemView.findViewById(R.id.textViewRestaurant);
            this.textViewPrice = itemView.findViewById(R.id.textViewPrice);

            //System.out.println(textViewDate);
            //System.out.println(textViewRestaurant);
            //System.out.println(textViewPrice);

        }
    }
}
