package com.athrved.masterclass;

public class IFreeHelperClass {
    int iimagesmall1,iimagesmall2;
    String ititle, itopic,iauthor;

    public IFreeHelperClass() {
    }

    public IFreeHelperClass(int iimagesmall1, int iimagesmall2, String ititle, String itopic, String iauthor) {
        this.iimagesmall1 = iimagesmall1;
        this.iimagesmall2 = iimagesmall2;
        this.ititle = ititle;
        this.itopic = itopic;
        this.iauthor = iauthor;
    }

    public int getIimagesmall1() {
        return iimagesmall1;
    }

    public void setIimagesmall1(int iimagesmall1) {
        this.iimagesmall1 = iimagesmall1;
    }

    public int getIimagesmall2() {
        return iimagesmall2;
    }

    public void setIimagesmall2(int iimagesmall2) {
        this.iimagesmall2 = iimagesmall2;
    }

    public String getItitle() {
        return ititle;
    }

    public void setItitle(String ititle) {
        this.ititle = ititle;
    }

    public String getItopic() {
        return itopic;
    }

    public void setItopic(String itopic) {
        this.itopic = itopic;
    }

    public String getIauthor() {
        return iauthor;
    }

    public void setIauthor(String iauthor) {
        this.iauthor = iauthor;
    }
}
