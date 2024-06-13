package com.example.onlinedoctorappointmentservice;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

public class Screen1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screen1, container, false);

        Button moveToReactNativeButton = view.findViewById(R.id.move_to_react_native_button);
        moveToReactNativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch ReactNative app
                // You can add code here to launch the ReactNative app

                // For demonstration, we'll navigate to Screen2Fragment after simulating ReactNative app
                ((MainActivity) requireActivity()).loadFragment(new Screen2Fragment(), true);
            }
        });

        return view;
    }
}
