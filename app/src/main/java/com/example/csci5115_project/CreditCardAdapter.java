package com.example.csci5115_project;

/**
 * Created by karanjaswani on 1/12/18.
 */
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.santalu.widget.MaskEditText;

import java.util.ArrayList;
import java.util.List;

public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.CreditViewHolder> {


    //for popup button
//    Context mContext;
    CustomItemClickListener listener;
//    Button savecc;
//    Button cancelcc;
    //end popup

    private MaskEditText editText;
    //this context we will use to inflate the layout
    private Context mCtx;
//    private Dialog alert;

    //we are storing all the products in a list
    private List<CreditCard> cardList;

//    private AlertDialog.Builder alert = new AlertDialog.Builder(mCtx);
    private AlertDialog alert;


    @Override
    public CreditViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_creditcards, null);
//        return new CreditViewHolder(view, mCtx);
        //for popup button
        final CreditViewHolder mViewHolder = new CreditViewHolder(view, mCtx);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getAdapterPosition());
            }
        });
        return mViewHolder;

        //end popup
    }

    @Override
    public void onBindViewHolder(CreditViewHolder holder, int position) {
        //getting the product of the specified position
        CreditCard creditcard = cardList.get(position);
        ///for popup
        holder.textViewCardTitle.setText(cardList.get(position).getTitle());
        ///end popup
        //binding the data with the viewholder views
        holder.textViewCardTitle.setText(creditcard.getTitle());
        holder.textViewCardHolder.setText(creditcard.getOwner());
        holder.textViewCardNumber.setText(creditcard.getCardnumber());
        holder.textViewExpiration.setText(creditcard.getExpiration());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(creditcard.getImage()));
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }



    //getting the context and product list with constructor
    public CreditCardAdapter(Context mCtx, List<CreditCard> cardList,
                             //for popup
                             CustomItemClickListener listener
                             ///end for popup
    ) {
        this.mCtx = mCtx;
        this.cardList = cardList;

        //for popup
        this.listener = listener;
        //end popup
    }

    class CreditViewHolder extends RecyclerView.ViewHolder
//            implements View.OnClickListener {
    // for popup
    {
        //end popup
//        public TextView itemTitle;
        TextView textViewCardTitle;
        TextView textViewCardHolder;
        TextView textViewCardNumber;
        TextView textViewExpiration;
//        EditText editCardTitle;
//        EditText editCardNumber;
//        EditText editCardExpiration;
        ImageView imageView;
        Context ctx;

        public CreditViewHolder(View itemView, Context ctx) {
            super(itemView);
//            this.creditcard = creditcard;
            this.ctx = ctx;
//            itemView.setOnClickListener(itemView);
            textViewCardHolder = itemView.findViewById(R.id.cardholder);
            textViewCardTitle = itemView.findViewById(R.id.textViewCardTitle);
            textViewCardNumber = itemView.findViewById(R.id.textViewCC);
            textViewExpiration = itemView.findViewById(R.id.textViewExp);
            imageView = itemView.findViewById(R.id.imageView);

            // create a popup window with credit card edits
//            itemView.setOnClickListener(new View.OnClickListener()  {
//                @Override
//                public void onClick(View v) {
//                    openDialog();
//                }
//            });

        }


//        public void openDialog(){
//            LayoutInflater inflater = LayoutInflater.from(mCtx);
//            View alertLayout = inflater.inflate(R.layout.popupwindow, null);
//            AlertDialog alertDialog = new AlertDialog.Builder(mCtx).create();
//            alertDialog.setView(alertLayout);
//
//            new Dialog(mCtx);
//            alertDialog.show();
//        }

//        @Override
        public void onClick(View v) {
            Intent startNewActivity = new Intent(v.getContext(), MainActivity.class);
            v.getContext().startActivity(startNewActivity);

        }
    }
}
