package com.example.gadseduca.models.retrofit.getusers.getquestuions;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadseduca.R;
import com.example.gadseduca.SendMessageActivity;
import com.example.gadseduca.UserInfoActivity;
import com.example.gadseduca.models.retrofit.login_reg.UsersList;

import java.util.List;

import static androidx.test.InstrumentationRegistry.getContext;
import static androidx.test.InstrumentationRegistry.getTargetContext;

public class GetUsersRecyclerView extends RecyclerView.Adapter<GetUsersRecyclerView.UserListViewHolder> {
    private Context context;
    private List<UsersList> usersLists;
    private View view;

    public GetUsersRecyclerView(Context context, List<UsersList> usersLists) {
        this.context = context;
        this.usersLists = usersLists;
    }

    @NonNull
    @Override
    public GetUsersRecyclerView.UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_recycler_view,parent,false);

        return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetUsersRecyclerView.UserListViewHolder holder, int position) {
        UsersList user = usersLists.get(position);
        holder.name.setText(user.getFirstname());
        holder.location.setText(user.getLocale_city()+", "+user.getLocale_country());
        holder.study.setText(user.getStudy());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userDetail = new Intent(context, UserInfoActivity.class);
                userDetail.putExtra("user_id", usersLists.get(position).getEmail());
                userDetail.putExtra("name", usersLists.get(position).getFirstname());
                userDetail.putExtra("study", usersLists.get(position).getStudy());
                userDetail.putExtra("loc", usersLists.get(position).getLocale_city());
                userDetail.putExtra("pix", usersLists.get(position).getPix_url());
                context.startActivity(userDetail);
            }
        });


    }

    @Override
    public int getItemCount() {
        return usersLists.size();
    }

    public class UserListViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView image;
        private TextView location;
        private TextView study;

        public UserListViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.person_img);
            location = itemView.findViewById(R.id.loc);
            study = itemView.findViewById(R.id.stud);

        }
    }
}
