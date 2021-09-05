package com.athrved.masterclass.machdesign;

public class MMenHelperClass {
    int mimage;
    String mname,mdes;

    public MMenHelperClass() {
    }

    public MMenHelperClass(int mimage, String mname, String mdes) {
        this.mimage = mimage;
        this.mname = mname;
        this.mdes = mdes;
    }

    public int getMimage() {
        return mimage;
    }

    public void setMimage(int mimage) {
        this.mimage = mimage;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMdes() {
        return mdes;
    }

    public void setMdes(String mdes) {
        this.mdes = mdes;
    }
}
