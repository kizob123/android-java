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

public class reg1Fragment extends Fragment {


    public reg1Fragment() {
        // Required empty public constructor
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
        Button to_specialization  = view.findViewById(R.id.to_specialization);

        final EditText email = view.findViewById(R.id.email);
        final EditText password = view.findViewById(R.id.password);

        final Bundle regBundle = new Bundle();

        Toast.makeText(getActivity().getApplicationContext(),""+getArguments().getString("age"),Toast.LENGTH_LONG).show();
        //FirstFragmentArgs.fromBundle(getArguments()).getTestString()
        to_specialization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getArguments().putString("email",email.getText().toString());
                //getArguments().putString("password",password.getText().toString());
                regBundle.putString("firstname",getArguments().getString("firstname"));
                regBundle.putString("lastname",getArguments().getString("lastname"));
                regBundle.putString("age",getArguments().getString("age"));
                regBundle.putString("city_locale",getArguments().getString("city_locale"));
                regBundle.putString("country_locale",getArguments().getString("country_locale"));

                regBundle.putString("email",email.getText().toString());
                regBundle.putString("password",password.getText().toString());
                navController.navigate(R.id.action_reg1Fragment_to_reg2Fragment,regBundle);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg1, container, false);
    }
}