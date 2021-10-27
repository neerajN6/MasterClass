package com.athrved.masterclass;

public class ProfileHelper {

    private String mName;
    private String mEmail;
    private Long mPhone;
    private String mBio;

    public ProfileHelper(){
        //Empty Constructor
    }

    public ProfileHelper(String name, String email, Long phone , String bio){


        if(bio.trim().equals("")){
            bio = "";
        }

        mName = name;
        mEmail = email;
        mPhone = phone;
        mBio = bio;
    }

    public ProfileHelper(String toString) {
    }


    public String getuName() {
        return mName;
    }

    public void setuName(String name) {
        mName = name;
    }

    public String getuEmail() {
        return mEmail;
    }

    public void setuEmail(String email) {
        mEmail = email;
    }

    public Long getuPhone() { return mPhone; }

    public void setuPhone(Long desc) {
        mPhone = desc;
    }

    public String getuBio() {
        return mBio;
    }

    public void setuBio(String Designation) {
        mBio = Designation;
    }
}
