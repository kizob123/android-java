package com.example.gadseduca.parts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadseduca.QuestActivity;
import com.example.gadseduca.R;
import com.example.gadseduca.adapters.pageradapt.QuestsPagerAdapt;

import java.util.Objects;


public class QuestsFragment extends Fragment {

    ViewPager2 questsViewPager;
    QuestsPagerAdapt questsPagerAdapt;


    public QuestsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        questsViewPager = view.findViewById(R.id.quests_pager);
        questsPagerAdapt = new QuestsPagerAdapt(requireActivity());
        questsViewPager.setAdapter(questsPagerAdapt);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quests, container, false);
    }
}