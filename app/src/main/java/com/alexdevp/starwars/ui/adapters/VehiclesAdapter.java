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
import com.alexdevp.starwars.model.Vehicle;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder> {

    private Vehicle[] vehicles;
    private Context context;
    ItemClickListener mItemListener;

    public VehiclesAdapter(Context context, ItemClickListener mItemListener) {
        this.vehicles = new Vehicle[]{};
        this.context = context;
        this.mItemListener = mItemListener;
    }

    @NonNull
    @Override
    public VehiclesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        return new VehiclesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesViewHolder holder, int position) {
        holder.bind(vehicles[position]);
        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(vehicles[position]);
        });
    }

    @Override
    public int getItemCount() {
        return this.vehicles.length;
    }

    public Object getItem(int position) {
        return this.vehicles[position];
    }

    public interface ItemClickListener{
        void onItemClick(Vehicle vehicle);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(Vehicle[] vehicleList) {
        this.vehicles = vehicleList;
        notifyDataSetChanged();
    }

    public class VehiclesViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public VehiclesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_row_name);
            imageView = itemView.findViewById(R.id.imageView_row_image);
        }

        public void bind(Vehicle vehicle) {
            textView.setText(vehicle.getName());
            imageView.setImageResource(R.drawable.ic_arrow);
        }
    }
}
