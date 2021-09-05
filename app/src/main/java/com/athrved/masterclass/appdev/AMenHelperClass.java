package com.athrved.masterclass.appdev;

public class AMenHelperClass {
    int aimage;
    String aname,ades;

    public AMenHelperClass() {
    }

    public AMenHelperClass(int aimage, String aname, String ades) {
        this.aimage = aimage;
        this.aname = aname;
        this.ades = ades;
    }

    public int getAimage() {
        return aimage;
    }

    public void setAimage(int aimage) {
        this.aimage = aimage;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades;
    }
}
