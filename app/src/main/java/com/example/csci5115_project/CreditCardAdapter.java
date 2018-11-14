package com.example.csci5115_project;

/**
 * Created by karanjaswani on 1/12/18.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.CreditViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<CreditCard> cardList;

    //getting the context and product list with constructor
    public CreditCardAdapter(Context mCtx, List<CreditCard> cardList) {
        this.mCtx = mCtx;
        this.cardList = cardList;
    }

    @Override
    public CreditViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_creditcards, null);
        return new CreditViewHolder(view, mCtx);
    }

    @Override
    public void onBindViewHolder(CreditViewHolder holder, int position) {
        //getting the product of the specified position
        CreditCard creditcard = cardList.get(position);

        //binding the data with the viewholder views
//        holder.textViewTitle.setText(creditcard.getTitle());
//        holder.textViewShortDesc.setText(creditcard.getShortdesc());
//        holder.textViewRating.setText(String.valueOf(product.getRating()));
//        holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(creditcard.getImage()));

    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }


    class CreditViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;
        Context ctx;
        ArrayList<CreditCard> creditcard = new ArrayList<CreditCard>();

        public CreditViewHolder(View itemView, Context ctx) {
            super(itemView);
            this.creditcard = creditcard;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
//            textViewRating = itemView.findViewBsid.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View v) {
//            int position = getAdapterPosition();
//            Product this_product = this.products.get(position);
//            Intent intent = new Intent(ctx, )

        }
    }
}
