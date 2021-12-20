package com.example.gadseduca.forquestions;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gadseduca.R;

public class SetQuestionSubjectTopicFragment extends Fragment {



    public SetQuestionSubjectTopicFragment() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        final Bundle topic_bundle = new Bundle();
        final EditText q_topic = view.findViewById(R.id.input_topic);
        final EditText q_intent = view.findViewById(R.id.question_intent);
        final Button to_question_details  = view.findViewById(R.id.to_question_details);
        final CheckBox q_optionable = view.findViewById(R.id.optionable);
        to_question_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean testinput = q_topic.getText().toString().trim().equals("")||q_intent.getText().toString().trim().equals("");
                if(!testinput) {
                    topic_bundle.putString("topic", q_topic.getText().toString());
                    topic_bundle.putString("intent", q_intent.getText().toString());
                    topic_bundle.putBoolean("optionable", q_optionable.isChecked());
                    navController.navigate(R.id.action_setQuestionSubjectTopicFragment_to_setQuestioDetailsFragment, topic_bundle);
                }
                else {
                    Toast.makeText(getContext(), "You must fill in all input to continue", Toast.LENGTH_LONG).show();
                    if(q_topic.getText().toString().trim().equals(""))
                        q_topic.hasFocus();
                    if(q_intent.getText().toString().trim().equals(""))
                        q_intent.hasFocus();
                }
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_question_subject_topic, container, false);
    }
}