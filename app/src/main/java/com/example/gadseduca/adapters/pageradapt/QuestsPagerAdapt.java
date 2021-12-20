package com.example.gadseduca.adapters.pageradapt;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gadseduca.parts.MessageFragment;
import com.example.gadseduca.parts.OnlineUsersFragment;
import com.example.gadseduca.parts.QuestionsFragment;

public class QuestsPagerAdapt extends FragmentStateAdapter {
    public QuestsPagerAdapt(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment[] Quests ={new QuestionsFragment(), OnlineUsersFragment.newInstance(),new MessageFragment()};

        return Quests[position];
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
