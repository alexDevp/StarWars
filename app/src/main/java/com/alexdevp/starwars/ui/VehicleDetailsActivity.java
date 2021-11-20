package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.Vehicle;

public class VehicleDetailsActivity extends AppCompatActivity {

    private TextView text_view_name;
    private TextView text_view_model;
    private TextView text_view_manufacturer;
    private TextView text_view_cost_in_credits;
    private TextView text_view_length;
    private TextView text_view_max_atmosphering_speed;
    private TextView text_view_crew;
    private TextView text_view_passengers;
    private TextView text_view_cargo_capacity;
    private TextView text_view_consumables;
    private TextView text_view_vehicle_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);
        findViews();
        Vehicle vehicle = (Vehicle) getIntent().getExtras().get("Vehicle");
        setContents(vehicle);
    }

    private void findViews() {
        this.text_view_name = findViewById(R.id.text_view_name_value);
        this.text_view_model = findViewById(R.id.text_view_model_value);
        this.text_view_manufacturer = findViewById(R.id.text_view_manufacturer_value);
        this.text_view_cost_in_credits = findViewById(R.id.text_view_cost_in_credits_value);
        this.text_view_length = findViewById(R.id.text_view_length_value);
        this.text_view_max_atmosphering_speed = findViewById(R.id.text_view_max_atmosphering_speed_value);
        this.text_view_crew = findViewById(R.id.text_view_crew_value);
        this.text_view_passengers = findViewById(R.id.text_view_passengers_value);
        this.text_view_cargo_capacity = findViewById(R.id.text_view_cargo_capacity_value);
        this.text_view_consumables = findViewById(R.id.text_view_consumables_value);
        this.text_view_vehicle_class = findViewById(R.id.text_view_vehicle_class_value);
    }

    private void setContents(Vehicle vehicle) {
        this.text_view_name.setText(vehicle.getName());
        this.text_view_model.setText(vehicle.getModel());
        this.text_view_manufacturer.setText(vehicle.getManufacturer());
        this.text_view_cost_in_credits.setText(vehicle.getCost_in_credits());
        this.text_view_length.setText(vehicle.getLength());
        this.text_view_max_atmosphering_speed.setText(vehicle.getMax_atmosphering_speed());
        this.text_view_crew.setText(vehicle.getCrew());
        this.text_view_passengers.setText(vehicle.getPassengers());
        this.text_view_cargo_capacity.setText(vehicle.getCargo_capacity());
        this.text_view_consumables.setText(vehicle.getConsumables());
        this.text_view_vehicle_class.setText(vehicle.getVehicle_class());
    }
}