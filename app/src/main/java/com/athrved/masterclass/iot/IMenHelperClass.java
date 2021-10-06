package com.athrved.masterclass.iot;

public class IMenHelperClass {
    int iimage;
    String iname,ides;

    public IMenHelperClass() {
    }

    public IMenHelperClass(int iimage, String iname, String ides) {
        this.iimage = iimage;
        this.iname = iname;
        this.ides = ides;
    }

    public int getIimage() {
        return iimage;
    }

    public void setIimage(int iimage) {
        this.iimage = iimage;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIdes() {
        return ides;
    }

    public void setIdes(String ides) {
        this.ides = ides;
    }
}
