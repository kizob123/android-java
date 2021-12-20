package com.example.gadseduca.registerlogin.forregistration;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.work.OneTimeWorkRequest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gadseduca.R;
import com.example.gadseduca.models.retrofit.login_reg.CreateAUserWork;
import com.example.gadseduca.models.retrofit.login_reg.RegisterLoginRetrofitAPI;
import com.example.gadseduca.models.retrofit.login_reg.RetrofitClientForLoginorRegistration;
import com.example.gadseduca.models.retrofit.login_reg.UsersList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

public class ConfirmFragment extends Fragment {



    public ConfirmFragment() {
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);
        final   NavController navController = Navigation.findNavController(getActivity(),R.id.login_nav);
        TextView firstname = view.findViewById(R.id.first);
        TextView lastname = view.findViewById(R.id.last);
        TextView email = view.findViewById(R.id.e_mail);
        TextView age = view.findViewById(R.id.a_ge);
        TextView city = view.findViewById(R.id.city_l);
        TextView country = view.findViewById(R.id.country_l);
        TextView study = view.findViewById(R.id.stud_y);
        TextView research = view.findViewById(R.id.re_search);


        String first_n = getArguments().getString("firstname");
        firstname.setText(first_n);

        String last_n = getArguments().getString("lastname");
        lastname.setText(last_n);

        Integer ag = Integer.parseInt(getArguments().getString("age"));
        age.setText(ag.toString());

        String em = getArguments().getString("email");
        email.setText(em);

        String ct = getArguments().getString("city");
        city.setText(ct);


        String cntry = getArguments().getString("country");
        country.setText(cntry);
        String stud = getArguments().getString("study");
        study.setText(stud);
        String resch = getArguments().getString("research");
        research.setText(resch);
        String pw = getArguments().getString("password");
        view.findViewById(R.id.end_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofitClientForLoginorRegistration = RetrofitClientForLoginorRegistration.getRetrofitinstance();
                RegisterLoginRetrofitAPI registerLoginRetrofitAPI = retrofitClientForLoginorRegistration.create(RegisterLoginRetrofitAPI.class);
                UsersList usersList= new UsersList(ag,first_n,last_n,ct,cntry,"",em,pw,stud,"","");
                Call<UsersList> call = registerLoginRetrofitAPI.createUser(usersList);
                TextView notice = view.findViewById(R.id.textView9);
                call.enqueue(new Callback<UsersList>() {
                    @Override
                    public void onResponse(Call<UsersList> call, Response<UsersList> response) {
                        UsersList responseFromApi = response.body();
                        String resonseString = "User: "+ responseFromApi.getFirstname()+" has been stored";
                        Toast.makeText(getContext(),resonseString,Toast.LENGTH_LONG).show();
                        navController.navigate(R.id.action_confirmFragment_to_questActivity);
                    }

                    @Override
                    public void onFailure(Call<UsersList> call, Throwable t) {
                        String fail = "User: "+ usersList.getFirstname()+" was not stored: check your internet, "+t.getMessage();
                        // Toast.makeText(getApplicationContext(),fail,Toast.LENGTH_LONG);

                        // notice.setTextColor(getResources().getColor(R.color.purple_200));
                      Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });


            }
        });

        return view;
    }
}