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
import android.widget.TextView;
import android.widget.Toast;

import com.example.gadseduca.R;
import com.example.gadseduca.models.retrofit.QuestionsList;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.q.GetQuestuionAPI;
import com.example.gadseduca.models.retrofit.login_reg.RetrofitClientForLoginorRegistration;
import com.example.gadseduca.models.retrofit.login_reg.UsersList;

import java.time.Instant;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ConfirmQuestionDetailFragment extends Fragment {


    public ConfirmQuestionDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final NavController navController = Navigation.findNavController(getActivity(),R.id.q_nav);
        final Bundle confirm = new Bundle();

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.popBackStack();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this,callback);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        final Button confirm  = view.findViewById(R.id.sub_q);
        //final Bundle confirm_bundle = new Bundle();

        final TextView topic= view.findViewById(R.id.topic);
        String topic1 = getArguments().getString("topic");
        topic.setText(topic1);

        final TextView intent= view.findViewById(R.id.intent_q);
        String intent1 = getArguments().getString("intent");
        intent.setText(intent1);

        final TextView optionable= view.findViewById(R.id.option_);
        String optionable1 = String.valueOf(getArguments().getBoolean("optionable"));
        optionable.setText(optionable1);

        final TextView detail= view.findViewById(R.id.detail);
        String detail1 = getArguments().getString("details");
        detail.setText(detail1);

        final TextView option_1= view.findViewById(R.id.options_1);
        String option1 = getArguments().getString("opt1");
        option_1.setText(option1);
        final TextView option_2= view.findViewById(R.id.options_2);
        String option2 = getArguments().getString("opt2");
        option_2.setText(option2);
        final TextView option_3= view.findViewById(R.id.options_3);
        String option3 = getArguments().getString("opt3");
        option_3.setText(option3);
        final TextView option_4= view.findViewById(R.id.options_4);
        String option4 = getArguments().getString("opt4");
        option_4.setText(option4);

        final TextView true_answer= view.findViewById(R.id.true_answer);
        final String true_ans_op = getArguments().getString("true_answer");


        true_answer.setText(true_ans_op);

        final Button sub_q= view.findViewById(R.id.sub_q);

        sub_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String true_ans = null;
                switch (true_ans_op){
                    case "option 1": true_ans=option1;break;
                    case "option 2": true_ans=option2;break;
                    case "option 3": true_ans=option3;break;
                    case "option 4": true_ans=option4;break;

                }
                Date date = Date.from(Instant.now());
                Toast.makeText(getContext(),date.toString()+" -"+true_ans+" -"+optionable1,Toast.LENGTH_LONG).show();
                QuestionsList questionsList = new QuestionsList(topic1,intent1,detail1,optionable1,
                       option1,option2,option3,option4,true_ans,date.toString(),"",4);
                Retrofit retrofit = RetrofitClientForLoginorRegistration.getRetrofitinstance();
                GetQuestuionAPI getQuestuionAPI = retrofit.create(GetQuestuionAPI.class);
                Call<QuestionsList> questionsListCall = getQuestuionAPI.createQuestion(questionsList);

                TextView notice = view.findViewById(R.id.textView9);
                questionsListCall.enqueue(new Callback<QuestionsList>() {
                    @Override
                    public void onResponse(Call<QuestionsList> call, Response<QuestionsList> response) {
                        QuestionsList questionsList1 = response.body();
                        String resonseString = "Question: "+ questionsList1.getTopic()+" has been stored";
                        Toast.makeText(getContext(),resonseString,Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<QuestionsList> call, Throwable t) {
                        Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
                navController.navigate(R.id.action_confirmQuestionDetailFragment_to_questActivity2);

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_question_detail, container, false);
    }
}