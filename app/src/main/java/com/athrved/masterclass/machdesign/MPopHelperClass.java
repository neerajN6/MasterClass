package com.athrved.masterclass.machdesign;

public class MPopHelperClass {
    int mimagebig, mimagesmall1,mimagesmall2;
    String mtitle, mtopic,mauthor,murl;

    public MPopHelperClass() {
    }

    public MPopHelperClass(int mimagebig, int mimagesmall1, int mimagesmall2, String mtitle, String mtopic, String mauthor, String murl) {
        this.mimagebig = mimagebig;
        this.mimagesmall1 = mimagesmall1;
        this.mimagesmall2 = mimagesmall2;
        this.mtitle = mtitle;
        this.mtopic = mtopic;
        this.mauthor = mauthor;
        this.murl = murl;
    }

    public int getMimagebig() {
        return mimagebig;
    }

    public void setMimagebig(int mimagebig) {
        this.mimagebig = mimagebig;
    }

    public int getMimagesmall1() {
        return mimagesmall1;
    }

    public void setMimagesmall1(int mimagesmall1) {
        this.mimagesmall1 = mimagesmall1;
    }

    public int getMimagesmall2() {
        return mimagesmall2;
    }

    public void setMimagesmall2(int mimagesmall2) {
        this.mimagesmall2 = mimagesmall2;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMtopic() {
        return mtopic;
    }

    public void setMtopic(String mtopic) {
        this.mtopic = mtopic;
    }

    public String getMauthor() {
        return mauthor;
    }

    public void setMauthor(String mauthor) {
        this.mauthor = mauthor;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }
}
