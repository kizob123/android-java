package com.example.gadseduca;

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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegisterFragment extends Fragment {


    public RegisterFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        final NavController navController = Navigation.findNavController(getActivity(),R.id.login_nav);
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
        final Bundle regBundle = new Bundle();
        final EditText firstname = view.findViewById(R.id.firstname);
        final EditText lastname = view.findViewById(R.id.lastname);
        final EditText age = view.findViewById(R.id.age);
        final EditText locale_city = view.findViewById(R.id.city_locale);
        final EditText locale_country = view.findViewById(R.id.country_locale);


        Button to_login_info = view.findViewById(R.id.to_login_info);
        to_login_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regBundle.putString("firstname",firstname.getText().toString());
                regBundle.putString("lastname",lastname.getText().toString());
                regBundle.putString("age",age.getText().toString());
                regBundle.putString("city_locale",locale_city.getText().toString());
                regBundle.putString("country_locale",locale_country.getText().toString());
                if(!regBundle.isEmpty())
                navController.navigate(R.id.action_registerFragment_to_reg1Fragment,regBundle);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }
}