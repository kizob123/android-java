package com.example.gadseduca.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class QuestionsList {
            @SerializedName("topic")
            private String topic;
            @SerializedName("intent")
            private String intent;
            @SerializedName("details")
            private String details;
            @SerializedName("question_optionable")
            private String question_optionable;
            @SerializedName("opt_a")
            private String opt_a;
            @SerializedName("opt_b")
            private String opt_b;
            @SerializedName("opt_c")
            private String opt_c;
            @SerializedName("opt_d")
            private String opt_d;
            @SerializedName("answer_option")
            private String answer_option;
            @SerializedName("date_time_posted")
            private String date_time_posted;
            @SerializedName("user_id")
            private String user_id;
            @SerializedName("time_limit")
            private int time_limit;

    public QuestionsList(String topic, String intent, String details, String question_optionable, String opt_a, String opt_b, String opt_c, String opt_d, String answer_option, String date_time_posted, String user_id, int time_limit) {
        this.topic = topic;
        this.intent = intent;
        this.details = details;
        this.question_optionable = question_optionable;
        this.opt_a = opt_a;
        this.opt_b = opt_b;
        this.opt_c = opt_c;
        this.opt_d = opt_d;
        this.answer_option = answer_option;
        this.date_time_posted = date_time_posted;
        this.user_id = user_id;
        this.time_limit = time_limit;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getQuestion_optionable() {
        return question_optionable;
    }

    public void setQuestion_optionable(String question_optionable) {
        this.question_optionable = question_optionable;
    }

    public String getOpt_a() {
        return opt_a;
    }

    public void setOpt_a(String opt_a) {
        this.opt_a = opt_a;
    }

    public String getOpt_b() {
        return opt_b;
    }

    public void setOpt_b(String opt_b) {
        this.opt_b = opt_b;
    }

    public String getOpt_c() {
        return opt_c;
    }

    public void setOpt_c(String opt_c) {
        this.opt_c = opt_c;
    }

    public String getOpt_d() {
        return opt_d;
    }

    public void setOpt_d(String opt_d) {
        this.opt_d = opt_d;
    }

    public String getAnswer_option() {
        return answer_option;
    }

    public void setAnswer_option(String answer_option) {
        this.answer_option = answer_option;
    }

    public String getDate_time_posted() {
        return date_time_posted;
    }

    public void setDate_time_posted(String date_time_posted) {
        this.date_time_posted = date_time_posted;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(int time_limit) {
        this.time_limit = time_limit;
    }
}
