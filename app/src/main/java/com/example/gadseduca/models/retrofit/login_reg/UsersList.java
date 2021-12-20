package com.example.gadseduca.models.retrofit.login_reg;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersList {

    @SerializedName("age")
    private Integer age;
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("locale_city")
    private String locale_city;
    @SerializedName("locale_country")
    private String locale_country;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("study")
    private String study;


    /*----login--8*/
    @SerializedName("username")
    private String username="user";
    @SerializedName("pix")
    private String pix_url="pix";
    @SerializedName("loggedin")
    private String loggedin;
    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getLoggedin() {
        return loggedin;
    }

    public void setLoggedin(String loggedin) {
        this.loggedin = loggedin;
    }

    public String getPix_url() {
        return pix_url;
    }

    public void setPix_url(String pix_url) {
        this.pix_url = pix_url;
    }

    public UsersList(Integer age, String firstname, String lastname, String locale_city, String locale_country, String username, String email, String password,String study,String pix_url,String loggedin) {
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.locale_city = locale_city;
        this.locale_country = locale_country;
        this.username = username;
       // this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.pix_url =pix_url;
        this.loggedin = loggedin;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLocale_city() {
        return locale_city;
    }

    public void setLocale_city(String locale_city) {
        this.locale_city = locale_city;
    }

    public String getLocale_country() {
        return locale_country;
    }

    public void setLocale_country(String locale_country) {
        this.locale_country = locale_country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
