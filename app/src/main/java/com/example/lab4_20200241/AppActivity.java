package com.example.lab4_20200241;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lab4_20200241.databinding.ActivityAppBinding;
import com.example.lab4_20200241.databinding.FragmentClimaBinding;
import com.example.lab4_20200241.databinding.FragmentGeoBinding;

public class AppActivity extends AppCompatActivity {

    ActivityAppBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}