package com.example.csci5115_project;

/**
 * Created by karanjaswani on 1/12/18.
 */
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
        holder.textViewCardTitle.setText(creditcard.getTitle());
        holder.textViewCardNumber.setText(creditcard.getCardnumber());
        holder.textViewExpiration.setText(creditcard.getExpiration());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(creditcard.getImage()));

    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }


    class CreditViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewCardTitle;
        TextView textViewCardNumber;
        TextView textViewExpiration;
        ImageView imageView;
        Context ctx;
        ArrayList<CreditCard> creditcard = new ArrayList<CreditCard>();

//        LinearLayout popup;

        public CreditViewHolder(View itemView, Context ctx) {
            super(itemView);
//            this.creditcard = creditcard;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            textViewCardTitle = itemView.findViewById(R.id.textViewCardTitle);
            textViewCardNumber = itemView.findViewById(R.id.textViewCC);
            textViewExpiration = itemView.findViewById(R.id.textViewExp);
            imageView = itemView.findViewById(R.id.imageView);


            // create a popup window with credit card edits

            itemView.setOnClickListener(new View.OnClickListener()  {
                @Override
                public void onClick(View v) {
                    showPopup(pview);
                }
            });

            // end pop up window
        }

        LayoutInflater popupinflate = LayoutInflater.from(mCtx);
        View pview = popupinflate.inflate(R.layout.layout_products, null);

        public void showPopup(View view) {
            View popupView = LayoutInflater.from(mCtx).inflate(R.layout.popupwindow, null);
//            final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            Button btnDismiss = (Button) popupView.findViewById(R.id.close);
            Button btnOrder = (Button) popupView.findViewById(R.id.okorder);
            btnDismiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            btnOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startNewActivity = new Intent(mCtx, Restaurant_Page.class);
                    mCtx.startActivity(startNewActivity);
                }
            });
            popupWindow.showAsDropDown(view, 160, 400);
        }



        @Override
        public void onClick(View v) {
            Intent startNewActivity = new Intent(v.getContext(), MainActivity.class);
            v.getContext().startActivity(startNewActivity);

        }
    }
}
