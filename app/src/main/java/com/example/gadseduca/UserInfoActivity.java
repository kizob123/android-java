package com.example.gadseduca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Button send_message = findViewById(R.id.send_m);
        TextView user = findViewById(R.id.users_name);
        Intent extras = getIntent();

        user.setText(extras.getStringExtra("user_id"));
        TextView study = findViewById(R.id.user_study);
        study.setText(extras.getStringExtra("study"));
        TextView loc = findViewById(R.id.user_location);
        loc.setText(extras.getStringExtra("loc"));
        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_to_send_message= new Intent(getApplicationContext(),SendMessageActivity.class);
                go_to_send_message.putExtra("users_email",user.getText().toString());
                startActivity(go_to_send_message);

            }
        });
    }
}