package com.example.csci5115_project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<com.example.csci5115_project.FavoriteAdapter.FavoriteViewHolder> {
    // context to inflate the layout
    private Context mCtx;

    // store all the favorites in a list
    private List<Favorite> favoriteList;

    // get  context and favorites list with constructor
    public FavoriteAdapter(Context mCtx, List<Favorite> favoriteList) {
        this.mCtx = mCtx;
        this.favoriteList = favoriteList;
    }

    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       //inflating and returning our view holder
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.content_main, null);
            return new FavoriteViewHolder(view, mCtx);
        }

        @Override
        public void onBindViewHolder(FavoriteViewHolder holder, int position) {
            //getting the product of the specified position
            Favorite favorite = favoriteList.get(position);
            //binding the data with the viewHolder views
            holder.textViewName.setText(favorite.getName());
            holder.textViewRestaurant.setText(favorite.getRestaurant());
            holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(favorite.getImage()));

        }


        @Override
        public int getItemCount() {
            return favoriteList.size();
        }


        class FavoriteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView textViewName, textViewRestaurant;
            ImageView imageView;
            Context ctx;
            ArrayList<Favorite> favorites = new ArrayList<Favorite>();

            public FavoriteViewHolder(View itemView, Context ctx) {
                super(itemView);
                this.favorites = favorites;
                this.ctx = ctx;
                itemView.setOnClickListener(this);
                textViewName = itemView.findViewById(R.id.textViewName);
                textViewRestaurant = itemView.findViewById(R.id.textViewRestaurantName);
                imageView = itemView.findViewById(R.id.imageViewFavorite);
            }

            @Override
            public void onClick(View v) {
//            int position = getAdapterPosition();
//            Product this_product = this.products.get(position);
//            Intent intent = new Intent(ctx, )
            }
        }
}
