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
import com.alexdevp.starwars.model.Film;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {

    private Film[] films;
    private Context context;
    ItemClickListener mItemListener;

    public FilmsAdapter(Context context, ItemClickListener itemClickListener) {

        this.context = context;
        this.films = new Film[]{};
        this.mItemListener = itemClickListener;
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        return new FilmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.bind(films[position]);
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(films[position]);
        });
    }

    @Override
    public int getItemCount() {
        return this.films.length;
    }

    public Object getItem(int position) {
        return this.films[position];
    }

    public interface ItemClickListener{
        void onItemClick(Film film);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(Film[] filmList) {
        this.films = filmList;
        notifyDataSetChanged();
    }

    public class FilmsViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public FilmsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_row_name);
            imageView = itemView.findViewById(R.id.imageView_row_image);
        }

        public void bind(Film film) {
            textView.setText(film.getTitle());
            imageView.setImageResource(R.drawable.ic_arrow);
        }
    }

}
