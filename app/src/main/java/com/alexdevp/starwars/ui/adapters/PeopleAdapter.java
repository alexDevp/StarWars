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
import com.alexdevp.starwars.model.People;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {

    private People[] people;
    private Context context;
    ItemClickListener mItemListener;

    public PeopleAdapter(Context context, ItemClickListener mItemListener) {
        this.people = new People[]{};
        this.context = context;
        this.mItemListener = mItemListener;
    }

    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder holder, int position) {
        holder.bind(people[position]);
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(people[position]);
        });
    }

    @Override
    public int getItemCount() {
        return this.people.length;
    }

    public interface ItemClickListener {
        void onItemClick(People peopleList);
    }

    public void updateList(People[] peopleList) {
        this.people = peopleList;
        notifyDataSetChanged();
    }

    public class PeopleViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public PeopleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_row_name);
            imageView = itemView.findViewById(R.id.imageView_row_image);
        }

        public void bind(People people) {
            textView.setText(people.getName());
            imageView.setImageResource(R.drawable.ic_arrow);
        }
    }
}
