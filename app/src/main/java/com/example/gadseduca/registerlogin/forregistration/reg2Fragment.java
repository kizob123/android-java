package com.example.gadseduca.registerlogin.forregistration;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gadseduca.R;

import java.util.Objects;

public class reg2Fragment extends Fragment {


    public reg2Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        final NavController navController = Navigation.findNavController(requireActivity(),R.id.login_nav);
//        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                navController.popBackStack();
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(this,callback);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        Button to_load_pix  = view.findViewById(R.id.to_load_pix);

        EditText research = view.findViewById(R.id.research);
        EditText study = view.findViewById(R.id.study);
        Bundle regBundle = new Bundle();

        Toast.makeText(getActivity().getApplicationContext(),""+getArguments().getString("password")+" "+getArguments().getString("firstname"),Toast.LENGTH_LONG).show();
        to_load_pix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regBundle.putString("firstname",getArguments().getString("firstname"));
                regBundle.putString("lastname",getArguments().getString("lastname"));
                regBundle.putString("age",getArguments().getString("age"));
                regBundle.putString("city_locale",getArguments().getString("city_locale"));
                regBundle.putString("country_locale",getArguments().getString("country_locale"));

                regBundle.putString("email",getArguments().getString("email"));
                regBundle.putString("password",getArguments().getString("password"));

                regBundle.putString("study",study.getText().toString());
                regBundle.putString("research",research.getText().toString());

                navController.navigate(R.id.action_reg2Fragment_to_imageLoadFragment,regBundle);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg2, container, false);
    }
}