package com.example.csci5115_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EditCreditCardAdapter extends RecyclerView.Adapter<EditCreditCardAdapter.EditCreditCardViewHolder>{


    //this context we will use to inflate the layout
    private Context mCtx;
    private CreditCard card;
    private List<CreditCard> cardList;

    //we are storing all the products in a list
//    private final OnClickListener mOnClickListener = new MyOnClickListener();

    //getting the context and product list with constructor
    public EditCreditCardAdapter(Context mCtx, CreditCard card) {
        this.mCtx = mCtx;
        this.card = card;
    }

    @Override
    public EditCreditCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_editcreditcards, null);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(this, MainActivity.class);
//
//            }
//        });
        return new EditCreditCardViewHolder(view,mCtx);
    }

    @Override
    public void onBindViewHolder(EditCreditCardViewHolder holder, int position) {
        //getting the product of the specified position
        CreditCard card = cardList.get(position);
        //binding the data with the viewholder views
        holder.textViewTitle.setText(card.getTitle());
//        holder.textViewShortDesc.setText(card.getCardnumber());
//        holder.textViewRating.setText(String.valueOf(product.getRating()));
//        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewCardNumber.setText(card.getCardnumber());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(card.getImage()));

    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }


    class EditCreditCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        EditText textViewTitle, textViewCardNumber;
        ImageView imageView;
        Context ctx;

        public EditCreditCardViewHolder(View itemView, Context ctx) {
            super(itemView);
            this.ctx = ctx;
//            itemView.setOnClickListener(this);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
//            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
//            textViewRating = itemView.findViewBsid.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            textViewCardNumber = itemView.findViewById(R.id.edit_card_number);

//            itemView.setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View v) {
//                    Intent startNewActivity = new Intent(mCtx, Menu.class);
//                    mCtx.startActivity(startNewActivity);
//
//                }
//
//            });
        }

        @Override
        public void onClick(View v) {
        }
    }










}
