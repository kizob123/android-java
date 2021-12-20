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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gadseduca.R;

public class SetQuestioDetailsFragment extends Fragment {


    public SetQuestioDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        final Button to_confirm_question   = view.findViewById(R.id.to_confirm_question);
        final Bundle details_bundle = new Bundle();
        final EditText q_details = view.findViewById(R.id.question_detail);
        Spinner answer = view.findViewById(R.id.right_answer);
        final EditText opt_1 = view.findViewById(R.id.opt_1);
        final EditText opt_2 = view.findViewById(R.id.opt_2);
        final EditText opt_3 = view.findViewById(R.id.opt_3);
        final EditText opt_4 = view.findViewById(R.id.opt_4);
        final Spinner true_ans = view.findViewById(R.id.right_answer);

        if(getArguments().getBoolean("optionable")==false){
            opt_1.setEnabled(false);
            opt_1.setCursorVisible(false);
            opt_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"You Selected Not Have Options In This Question",Toast.LENGTH_LONG).show();
                }
            });
            opt_2.setEnabled(false);
            opt_2.setCursorVisible(false);
            opt_2.setEnabled(false);
            opt_2.setCursorVisible(false);
            opt_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"You Selected Not Have Options In This Question",Toast.LENGTH_LONG).show();
                }
            });
            opt_3.setEnabled(false);
            opt_3.setCursorVisible(false);
            opt_3.setEnabled(false);
            opt_3.setCursorVisible(false);
            opt_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"You Selected Not Have Options In This Question",Toast.LENGTH_LONG).show();
                }
            });
            opt_4.setEnabled(false);
            opt_4.setCursorVisible(false);
            opt_4.setEnabled(false);
            opt_4.setCursorVisible(false);
            opt_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"You Selected Not Have Options In This Question",Toast.LENGTH_LONG).show();
                }
            });

        }


        to_confirm_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), ""+answer.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                details_bundle.putString("topic",getArguments().getString("topic"));
                details_bundle.putString("intent",getArguments().getString("intent"));
                details_bundle.putBoolean("optionable",getArguments().getBoolean("optionable"));
                details_bundle.putString("details",q_details.getText().toString());
                String get_true_ans = String.valueOf(true_ans.getSelectedItem());
                details_bundle.putString("true_answer",get_true_ans);
                if(getArguments().getBoolean("optionable")) {
                    details_bundle.putString("opt1", opt_1.getText().toString());
                    details_bundle.putString("opt2", opt_2.getText().toString());
                    details_bundle.putString("opt3", opt_3.getText().toString());
                    details_bundle.putString("opt3", opt_4.getText().toString());
                }
                Boolean testinput = opt_1.getText().toString().trim().equals("")||opt_2.getText().toString().trim().equals("")
                        ||opt_3.getText().toString().trim().equals("")||opt_4.getText().toString().trim().equals("");
                Toast.makeText(getContext(), ""+testinput+" "+!q_details.getText().toString().trim().equals(""), Toast.LENGTH_LONG).show();
                if (!q_details.getText().toString().trim().equals("")) {
                    Toast.makeText(getContext(), "aa", Toast.LENGTH_LONG).show();
                    if (getArguments().getBoolean("optionable")&&!testinput) {
                        Toast.makeText(getContext(), "ab", Toast.LENGTH_LONG).show();
                            navController.navigate(R.id.action_setQuestioDetailsFragment_to_confirmQuestionDetailFragment, details_bundle);

                        Toast.makeText(getContext(), "a", Toast.LENGTH_LONG).show();

                    }
                    else if(!getArguments().getBoolean("optionable")){
                            navController.navigate(R.id.action_setQuestioDetailsFragment_to_confirmQuestionDetailFragment, details_bundle);
                        Toast.makeText(getContext(), "b", Toast.LENGTH_LONG).show();

                    }
                    else {

                                Toast.makeText(getContext(), "You must fill in all input to continue", Toast.LENGTH_LONG).show();
                        }
                }
                else {
                    Toast.makeText(getContext(), "You must fill in qeustion detail to continue", Toast.LENGTH_LONG).show();

                }

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final NavController navController = Navigation.findNavController(getActivity(),R.id.q_nav);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.popBackStack();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this,callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_questio_details, container, false);
    }
}