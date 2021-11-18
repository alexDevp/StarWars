package com.alexdevp.starwars.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.PlanetsViewHolder> {

    private Planet[] planets;
    private Context context;
    ItemClickListener mItemListener;

    public PlanetsAdapter(Context context, ItemClickListener itemClickListener) {

        this.context = context;
        this.planets = new Planet[]{};
        this.mItemListener = itemClickListener;
    }

    @NonNull
    @Override
    public PlanetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        return new PlanetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsViewHolder holder, int position) {
        holder.bind(planets[position]);
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(planets[position]);
        });
    }

    @Override
    public int getItemCount() {
        return this.planets.length;
    }

    public Object getItem(int position) {
        return this.planets[position];
    }

    public interface ItemClickListener{
        void onItemClick(Planet planet);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(Planet[] planetList) {
        this.planets = planetList;
        notifyDataSetChanged();
    }

    public class PlanetsViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public PlanetsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_row_name);
            imageView = itemView.findViewById(R.id.imageView_row_image);
        }

        public void bind(Planet planet) {
            textView.setText(planet.getName());
            imageView.setImageResource(R.drawable.ic_arrow);
        }
    }
}

