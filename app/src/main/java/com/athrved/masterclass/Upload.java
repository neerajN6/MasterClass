package com.athrved.masterclass;

public class Upload {

    private String mName;
    private String mImageUrl;
    private String mEmail;
    private String mDesc;
    private String mDesignation;
    private String mPhoneNo;

    public Upload(){
        //Empty Constructor
    }

    public Upload(String name, String imageUrl, String email, String desc , String Designation, String PhoneNo){

        if(name.trim().equals("")){
            name = "No name";
        }
        if(email.trim().equals("")){
            email = "No email";
        }
        if(desc.trim().equals("")){
            desc = "No desc";
        }
        if(Designation.trim().equals("")){
            Designation = "No Designation";
        }
        if(PhoneNo.trim().equals("")){
            PhoneNo = "No phone number";
        }
        mName = name;
        mImageUrl = imageUrl;
        mEmail = email;
        mDesc = desc;
        mDesignation = Designation;
        mPhoneNo = PhoneNo;
    }

    public Upload(String toString) {
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String email) {
        mEmail = email;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public String getDesignation() {
        return mDesignation;
    }

    public void setDesignation(String Designation) {
        mDesignation = Designation;
    }

    public String getPhoneNo() {
        return mPhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        mPhoneNo = PhoneNo;
    }
}
