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
import com.alexdevp.starwars.model.Starship;

public class StarshipsAdapter extends RecyclerView.Adapter<StarshipsAdapter.StarshipsViewHolder> {

    private Starship[] starships;
    private Context context;
    ItemClickListener mItemListener;

    public StarshipsAdapter(Context context, ItemClickListener mItemListener) {
        this.starships = new Starship[]{};
        this.context = context;
        this.mItemListener = mItemListener;
    }

    @NonNull
    @Override
    public StarshipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        return new StarshipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarshipsViewHolder holder, int position) {
        holder.bind(starships[position]);
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(starships[position]);
        });
    }

    @Override
    public int getItemCount() {
        return this.starships.length;
    }

    //public Object getItem(int position) {
    //    return this.starships[position];
    //}

    public interface ItemClickListener {
        void onItemClick(Starship starship);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(Starship[] starshipList) {
        this.starships = starshipList;
        notifyDataSetChanged();
    }

    public class StarshipsViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public StarshipsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_row_name);
            imageView = itemView.findViewById(R.id.imageView_row_image);
        }

        public void bind(Starship starship) {
            textView.setText(starship.getName());
            imageView.setImageResource(R.drawable.ic_arrow);
        }
    }

}
