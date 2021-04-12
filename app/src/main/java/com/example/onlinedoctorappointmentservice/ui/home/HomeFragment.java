package com.example.onlinedoctorappointmentservice.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlinedoctorappointmentservice.Cardiologist;
import com.example.onlinedoctorappointmentservice.General_Physician;
import com.example.onlinedoctorappointmentservice.NueroSurgeon;
import com.example.onlinedoctorappointmentservice.R;

import java.util.Objects;

public class HomeFragment extends Fragment {

    ImageView Heart,Brain,Dentist,Kidney,Eye;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_new);
        /*Heart.findViewById(R.id.brain);
        Brain.findViewById(R.id.brain);
        Dentist.findViewById(R.id.dentist);
        Kidney.findViewById(R.id.kidney);
        Eye.findViewById(R.id.eye);*/
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                generalPhyscian();
                Cardiologist();
                Nuerosurgeon();
                Dentist();
                KidneySpecialist();
                EyeSpecialist();
            }
        });
        return root;
    }
    public void generalPhyscian()
    {
        ImageView General= requireView().findViewById(R.id.general);
        General.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), General_Physician.class));
            }
        });
    }
    public void Cardiologist()
    {
        ImageView Heart= requireView().findViewById(R.id.heart);
        Heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Cardiologist.class));
            }
        });
    }
    public void Nuerosurgeon()
    {
        ImageView Brain=requireView().findViewById(R.id.brain);
        Brain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NueroSurgeon.class));
            }
        });
    }
    public void Dentist()
    {
        ImageView Dentist=requireView().findViewById(R.id.dentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NueroSurgeon.class));
            }
        });
    }
    public void KidneySpecialist()
    {
        ImageView Kidney=requireView().findViewById(R.id.kidney);
        Kidney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NueroSurgeon.class));
            }
        });
    }
    public void EyeSpecialist()
    {
        ImageView Eye=requireView().findViewById(R.id.eye);
        Eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NueroSurgeon.class));
            }
        });
    }
}
