package com.example.gadseduca;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.gadseduca.adapters.pageradapt.QuestsPagerAdapt;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class QuestActivity extends AppCompatActivity {


    ViewPager2 questsViewPager;
    QuestsPagerAdapt questsPagerAdapt;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        Toolbar toolbar = findViewById(R.id.toolb);
        setSupportActionBar(toolbar);
        questsViewPager = findViewById(R.id.quests_pager);
        questsPagerAdapt = new QuestsPagerAdapt(this);
        tabLayout = findViewById(R.id.quests_tabs);
//        Button create_question = findViewById(R.id.create_quest);
//        create_question.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent go_to_create_Q = new Intent(getApplicationContext(),CreateQuestionActivity.class);
//                startActivity(go_to_create_Q);
//            }
//        });
        questsViewPager.setAdapter(questsPagerAdapt);
        new TabLayoutMediator(tabLayout, questsViewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        String title[]={"Quests","Tacklers","Tips"};
                        tab.setText(title[position]);
                    }
                }).attach();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_head,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public void createQ(View view) {
        Intent go_to_create_Q = new Intent(this,CreateQuestionActivity.class);
         startActivity(go_to_create_Q);
    }
}