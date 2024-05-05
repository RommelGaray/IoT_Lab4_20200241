package com.example.lab4_20200241;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lab4_20200241.databinding.FragmentGeoBinding;
import com.example.lab4_20200241.dto.Geolocalizacion;
import com.example.lab4_20200241.services.GeolocalizacionService;

import java.util.concurrent.ExecutorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeoFragment extends Fragment {

    GeolocalizacionService geolocalizacionService;
    FragmentGeoBinding binding;

    /** Definimos las variables **/

    String sitio,sitioOficial;
    int limit = 1;
    String appid = "8dd6fc3be19ceb8601c2c3e811c16cf1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGeoBinding.inflate(inflater, container, false);


        /** Buscar CIUDAD **/
        binding.buscar.setOnClickListener(v -> {
            sitio = binding.ciudad.getText().toString();
            sitioOficial = "{" + sitio+"}";
            Log.d("msg-geo", "Ciudad: " + sitio);
            Log.d("msg-geo", "Ciudad Oficial: " + sitioOficial);


        });




        /** CONSULTA API**/
        geolocalizacionService = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GeolocalizacionService.class);

        if (tengoInternet()){
            geolocalizacionService.getGeolocalizacion(sitioOficial,limit,appid).enqueue(new Callback<Geolocalizacion>() {
                @Override
                public void onResponse(Call<Geolocalizacion> call, Response<Geolocalizacion> response) {
                    if(response.isSuccessful()){
                        Geolocalizacion geolocalizacion = response.body();

                        /**
                        GeoAdapter adapter = new GeoAdapter();
                        adapter.setContext(GeoFragment.this);

                        binding.recyclerView.setAdapter(adapter);
                        binding.recyclerView.setLayoutManager(new LinearLayoutManager(GeoFragment.this));
                         **/

                        Log.d("msg-geo", "Ciudad: " + geolocalizacion.getName());
                        Log.d("msg-geo", "Lat: " + geolocalizacion.getLat());
                        Log.d("msg-geo", "Lon: " + geolocalizacion.getLon());
                        binding.sitio.setText(geolocalizacion.getName());
//                        binding.lat.setText(geolocalizacion.getLat());
//                        binding.lon.setText(geolocalizacion.getLon());
                    }  else {
                        Log.d("msg-geo", "error en la respuesta del webservice");
                    }

                }
                @Override
                public void onFailure(Call<Geolocalizacion> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }







         /** CODIGO DEL NAVIGATION **/
        binding.clima.setOnClickListener(view -> {
            NavController navController = NavHostFragment.findNavController(GeoFragment.this);
            navController.navigate(GeoFragmentDirections.actionGeoFragmentToClimaFragment());
        });

        return binding.getRoot();
    }


    public boolean tengoInternet() {
        ConnectivityManager manager = (ConnectivityManager) requireContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        boolean tieneInternet = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        Log.d("msg-test-internet", "Internet: " + tieneInternet);

        return tieneInternet;
    }




}