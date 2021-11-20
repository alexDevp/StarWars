package com.alexdevp.starwars.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.model.Specie;


public class SpeciesAdapter extends RecyclerView.Adapter<SpeciesAdapter.SpeciesViewHolder> {

    private Specie[] species;
    private Context context;
    ItemClickListener mItemListener;

    public SpeciesAdapter(Context context, ItemClickListener mItemListener) {
        this.species = new Specie[]{};
        this.context = context;
        this.mItemListener = mItemListener;
    }

    @NonNull
    @Override
    public SpeciesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        return new SpeciesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesViewHolder holder, int position) {
        holder.bind(species[position]);
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(species[position]);
        });
    }

    @Override
    public int getItemCount() {
        return this.species.length;
    }

    public interface ItemClickListener{
        void onItemClick(Specie specie);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(Specie[] speciesList) {
        this.species = speciesList;
        notifyDataSetChanged();
    }

    public class SpeciesViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public SpeciesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_row_name);
            imageView = itemView.findViewById(R.id.imageView_row_image);
        }

        public void bind(Specie specie) {
            textView.setText(specie.getName());
            imageView.setImageResource(R.drawable.ic_arrow);
        }
    }

}
