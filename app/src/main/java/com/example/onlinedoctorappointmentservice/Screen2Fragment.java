package com.example.onlinedoctorappointmentservice;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Screen2Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_screen2, container, false);

        Button moveToScreen1Button = view.findViewById(R.id.move_to_screen1_button);
        moveToScreen1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to Screen 1
                getParentFragmentManager().popBackStack();
            }
        });

        return view;
    }
}
