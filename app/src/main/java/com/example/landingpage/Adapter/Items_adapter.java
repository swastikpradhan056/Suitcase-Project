package com.example.landingpage.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landingpage.R;
import com.example.landingpage.itemsModel;

import java.util.ArrayList;

public class Items_adapter extends RecyclerView.Adapter<Items_adapter.ItemViewHolder> {
    private final RecyclerViewItemClick recyclerViewItemClick;
    private ArrayList<itemsModel> itemsModels;

    public Items_adapter(RecyclerViewItemClick recyclerViewItemClick) {
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    @NonNull
    @Override
    public Items_adapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.single_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Items_adapter.ItemViewHolder holder, int position) {
    itemsModel itemsModel = itemsModels.get(position);

    }

    @Override
    public int getItemCount() {
        return itemsModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt_name, txt_price, txt_description;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.itemImage);
            txt_name = itemView.findViewById(R.id.itemName);
            txt_price = itemView.findViewById(R.id.itemPrice);
            txt_description = itemView.findViewById(R.id.itemDescription);

            itemView.setOnClickListener(this::itemViewOnClick);
        }

        private void itemViewOnClick(View view) {
            recyclerViewItemClick.onItemClick(view, getAdapterPosition());
        }
    }
}
