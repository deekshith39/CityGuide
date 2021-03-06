package com.example.cityguide.HelperClasses.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    ArrayList<CategoriesHelperClass> categories;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        //we havw to pass the view to featured viewHolder
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view, mListener);


        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        CategoriesHelperClass categoriesHelperClass = categories.get(position);

        //holder.image.setImageResource(categoriesHelperClass.getImage());
        holder.title.setText(categoriesHelperClass.getTitle());

    }

    @Override
    public int getItemCount() {

        return categories.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title,desc;
        RatingBar rating;
        public CategoriesViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            //image = itemView.findViewById(R.id.categories_image);
            title = itemView.findViewById(R.id.categories_title);

        }
    }


}
