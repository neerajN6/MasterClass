package com.athrved.masterclass.webdevelopment;

public class WMenHelperClass {
    int wimage;
    String wname,wdes;

    public WMenHelperClass() {
    }

    public WMenHelperClass(int wimage, String wname, String wdes) {
        this.wimage = wimage;
        this.wname = wname;
        this.wdes = wdes;
    }

    public int getWimage() {
        return wimage;
    }

    public void setWimage(int wimage) {
        this.wimage = wimage;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWdes() {
        return wdes;
    }

    public void setWdes(String wdes) {
        this.wdes = wdes;
    }
}
