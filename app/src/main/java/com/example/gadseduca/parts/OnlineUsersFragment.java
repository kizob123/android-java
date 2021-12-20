package com.example.gadseduca.parts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gadseduca.R;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.GetUsersAPI;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.GetUsersRecyclerView;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.RetrofitForGetUsersListUI;
import com.example.gadseduca.models.retrofit.login_reg.UsersList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class OnlineUsersFragment extends Fragment {

    private RecyclerView UsersRecycler;

    public OnlineUsersFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static OnlineUsersFragment newInstance() {
        OnlineUsersFragment fragment = new OnlineUsersFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Toast.makeText(getContext(),"online",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void getRecycled(List<UsersList> usersLists, View view){
        RecyclerView RV1 = view.findViewById(R.id.usersRV);
        final GetUsersRecyclerView getUsersRecyclerView = new GetUsersRecyclerView(getContext(),usersLists);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        RV1.setLayoutManager(linearLayoutManager);
        RV1.setAdapter(getUsersRecyclerView);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_online_users, container, true);
        Retrofit retrofit = RetrofitForGetUsersListUI.getRetrofitinstance();
        GetUsersAPI getUsersAPI = retrofit.create(GetUsersAPI.class);
        Call<List<UsersList>> call = getUsersAPI.getUser();

        call.enqueue(new Callback<List<UsersList>>() {
            @Override
            public void onResponse(Call<List<UsersList>> call, Response<List<UsersList>> response) {
                if(response.isSuccessful()){
                    List<UsersList> usersLists = response.body();
                    Toast.makeText(getContext(),""+usersLists.size(),Toast.LENGTH_LONG).show();
                getRecycled(usersLists, view);
                }
            }

            @Override
            public void onFailure(Call<List<UsersList>> call, Throwable t) {

            }
        });


        return view;
    }
}