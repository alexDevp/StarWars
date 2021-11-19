package com.alexdevp.starwars.ui.adapters.local.Repository;

import android.content.Context;

import com.alexdevp.starwars.dataSource.SwAPIDataSource;
import com.alexdevp.starwars.model.Vehicle;
import com.alexdevp.starwars.model.VehiclesResponse;
import com.alexdevp.starwars.services.VehiclesService;
import com.alexdevp.starwars.ui.adapters.local.AppDatabase;
import com.alexdevp.starwars.ui.adapters.local.DAO.VehicleDAO;
import com.alexdevp.starwars.ui.adapters.local.PreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatabaseRepositoryVehicles {

    public static Vehicle getVehicleByName(Context context, String name) {
        return AppDatabase.getInstance(context).getVehicleDao().getVehicleByName(name);
    }

    public static void getVehicles(Context context, final OnDataAvailableCallBack<Vehicle[]> callback) {
        final VehicleDAO vehicleDAO = AppDatabase.getInstance(context).getVehicleDao();

        new Thread(() -> {
            long lastSavedDate = PreferencesManager.getLastSavedDateVehicles(context);
            Vehicle[] vehicles = vehicleDAO.getVehicles();
            callback.onSuccess(vehicles);


            if (lastSavedDate < System.currentTimeMillis() - (5 * 60 * 1000) || vehicles.length == 0) {
                VehiclesService vehiclesService = SwAPIDataSource.getVehiclesService();

                Call<VehiclesResponse> call = vehiclesService.getVehicles();
                call.enqueue(new Callback<VehiclesResponse>() {
                    @Override
                    public void onResponse(Call<VehiclesResponse> call, Response<VehiclesResponse> response) {
                        if (response.isSuccessful()) {
                            final Vehicle[] vehiclesResponse = response.body().getResults();
                            new Thread(() -> {
                                vehicleDAO.deleteAllVehicles();
                                vehicleDAO.addVehicles(vehiclesResponse);
                                PreferencesManager.saveLastSavedDateVehicles(context, System.currentTimeMillis());
                                callback.onSuccess(vehiclesResponse);
                            }).start();
                        }
                    }

                    @Override
                    public void onFailure(Call<VehiclesResponse> call, Throwable t) {
                        callback.onError(t.getMessage());
                    }
                });
            }
        }).start();

    }

    public interface OnDataAvailableCallBack<T> {
        void onSuccess(T values);

        void onError(String Error);
    }
}
