package com.example.lab4_20200241;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.lab4_20200241.databinding.FragmentGeoBinding;
public class GeoFragment extends Fragment {

    FragmentGeoBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGeoBinding.inflate(inflater, container, false);

//        NavController navController = NavHostFragment.findNavController(GeoFragment.this);

        binding.clima.setOnClickListener(view -> {
            NavController navController = NavHostFragment.findNavController(GeoFragment.this);
            navController.navigate(GeoFragmentDirections.actionGeoFragmentToClimaFragment());
        });

//        binding.buscar.setOnClickListener(view -> {
//
//            NavController navController = NavHostFragment.findNavController(GeoFragment.this);
//            navController.navigate(GeoFragmentDirections.actionGeoFragmentToClimaFragment2());
//            //navController.navigate(R.id.action_fragmentA_to_fragmentB);
//        });



        return binding.getRoot();
    }
}