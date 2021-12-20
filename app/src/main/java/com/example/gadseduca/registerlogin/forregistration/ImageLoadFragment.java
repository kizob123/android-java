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
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.gadseduca.R;

public class ImageLoadFragment extends Fragment {


    public ImageLoadFragment() {
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
        NavController navController = Navigation.findNavController(view);
        Button finish = view.findViewById(R.id.load_pixs);
        ImageView load_pic = view.findViewById(R.id.imageView);
        Bundle regBundle = new Bundle();

        load_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImageFromGallery();
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regBundle.putString("firstname",getArguments().getString("firstname"));
                regBundle.putString("lastname",getArguments().getString("lastname"));
                regBundle.putString("age",getArguments().getString("age"));
                regBundle.putString("city_locale",getArguments().getString("city_locale"));
                regBundle.putString("country_locale",getArguments().getString("country_locale"));

                regBundle.putString("email",getArguments().getString("email"));
                regBundle.putString("password",getArguments().getString("password"));

                regBundle.putString("study",getArguments().getString("study"));
                regBundle.putString("research",getArguments().getString("research"));
                navController.navigate(R.id.action_imageLoadFragment_to_confirmFragment,regBundle);
            }
        });
    }

    private void getImageFromGallery() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_load, container, false);
    }
}