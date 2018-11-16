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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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

    private MaskEditText editText;
    //this context we will use to inflate the layout
    private Context mCtx;
//    private Dialog alert;

    //we are storing all the products in a list
    private List<CreditCard> cardList;

//    private AlertDialog.Builder alert = new AlertDialog.Builder(mCtx);
    private AlertDialog alert;

//    Button cancelbutton;
//    Button sendbutton;
//    Dialog popup;

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
//        EditText editCardTitle;
//        EditText editCardNumber;
//        EditText editCardExpiration;
        ImageView imageView;
        Context ctx;

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
                    openDialog();
                }
            });
        }



        public void openDialog(){

            AlertDialog alertDialog = new AlertDialog.Builder(mCtx).create();

            // Set Custom Title
            TextView title = new TextView(mCtx);
            // Title Properties
            title.setText("Custom Dialog Box");
            title.setPadding(10, 10, 10, 10);   // Set Position
            title.setGravity(Gravity.CENTER);
            title.setTextColor(Color.BLACK);
            title.setTextSize(20);
            alertDialog.setCustomTitle(title);

            // Set Message
            TextView msg = new TextView(mCtx);
            // Message Properties
            msg.setText("I am a Custom Dialog Box. \n Please Customize me.");
            msg.setGravity(Gravity.CENTER_HORIZONTAL);
            msg.setTextColor(Color.BLACK);
            alertDialog.setView(msg);

            // Set Button
            // you can more buttons
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Perform Action on Button
                }
            });

            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"CANCEL", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Perform Action on Button
                }
            });

            new Dialog(mCtx);
            alertDialog.show();

            // Set Properties for OK Button
            final Button okBT = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
            LinearLayout.LayoutParams neutralBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
            neutralBtnLP.gravity = Gravity.FILL_HORIZONTAL;
            okBT.setPadding(50, 10, 10, 10);   // Set Position
            okBT.setTextColor(Color.BLUE);
            okBT.setLayoutParams(neutralBtnLP);

            final Button cancelBT = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            LinearLayout.LayoutParams negBtnLP = (LinearLayout.LayoutParams) okBT.getLayoutParams();
            negBtnLP.gravity = Gravity.FILL_HORIZONTAL;
            cancelBT.setTextColor(Color.RED);
            cancelBT.setLayoutParams(negBtnLP);
        }

        @Override
        public void onClick(View v) {
            Intent startNewActivity = new Intent(v.getContext(), MainActivity.class);
            v.getContext().startActivity(startNewActivity);

        }
    }
}
