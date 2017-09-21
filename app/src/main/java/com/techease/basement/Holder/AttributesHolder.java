package com.techease.basement.Holder;

/**
 * Created by Adam Noor on 20-Sep-17.
 */

public class AttributesHolder {


    private String Username;
    private String Email;
    private String Date;

    //No attribute constuctor
    AttributesHolder()
    {

    }
    //Multiple attribute constructor
    public AttributesHolder(String Username,String Email, String Date)
    {
        this.Username=Username;
        this.Email=Email;
        this.Date=Date;
    }
    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
