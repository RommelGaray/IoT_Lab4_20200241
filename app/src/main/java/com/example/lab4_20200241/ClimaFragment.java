package com.example.lab4_20200241;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab4_20200241.databinding.FragmentClimaBinding;
import com.example.lab4_20200241.databinding.FragmentGeoBinding;
public class ClimaFragment extends Fragment {

    FragmentClimaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentClimaBinding.inflate(inflater, container, false);

        binding.geo.setOnClickListener(view -> {
            NavController navController = NavHostFragment.findNavController(ClimaFragment.this);
            navController.navigate(ClimaFragmentDirections.actionClimaFragmentToGeoFragment());
        });
        return binding.getRoot();
    }


}