package com.example.myapp;




import android.support.annotation.NonNull;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardRecyclerViewAdapter.ViewHolder> {

    private Context context;

    //we are storing all the products in a list
    private List<Tile> cardTile;


    public CardRecyclerViewAdapter(Context context, List<Tile> cardTile){

        this.context=context;
        this.cardTile=cardTile;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //getting the product of the specified position
        Tile Tile = cardTile.get(position);

        //binding the data with the viewholder views
        holder.Title.setText(Tile.getTitle());
        holder.subTitle.setText(Tile.getSubTitle());
  /*      holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));*/

    }

    @Override
    public int getItemCount() {
        return cardTile.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Title;
        public TextView subTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.sub_title);
        }
    }
}
