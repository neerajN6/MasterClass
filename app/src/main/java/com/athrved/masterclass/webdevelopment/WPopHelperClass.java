package com.athrved.masterclass.webdevelopment;

public class WPopHelperClass {
    int wimagebig, wimagesmall1,wimagesmall2;
    String wtitle, wtopic,wauthor,wurl;

    public WPopHelperClass() {
    }

    public WPopHelperClass(int wimagebig, int wimagesmall1, int wimagesmall2, String wtitle, String wtopic, String wauthor, String wurl) {
        this.wimagebig = wimagebig;
        this.wimagesmall1 = wimagesmall1;
        this.wimagesmall2 = wimagesmall2;
        this.wtitle = wtitle;
        this.wtopic = wtopic;
        this.wauthor = wauthor;
        this.wurl = wurl;
    }

    public int getWimagebig() {
        return wimagebig;
    }

    public void setWimagebig(int wimagebig) {
        this.wimagebig = wimagebig;
    }

    public int getWimagesmall1() {
        return wimagesmall1;
    }

    public void setWimagesmall1(int wimagesmall1) {
        this.wimagesmall1 = wimagesmall1;
    }

    public int getWimagesmall2() {
        return wimagesmall2;
    }

    public void setWimagesmall2(int wimagesmall2) {
        this.wimagesmall2 = wimagesmall2;
    }

    public String getWtitle() {
        return wtitle;
    }

    public void setWtitle(String wtitle) {
        this.wtitle = wtitle;
    }

    public String getWtopic() {
        return wtopic;
    }

    public void setWtopic(String wtopic) {
        this.wtopic = wtopic;
    }

    public String getWauthor() {
        return wauthor;
    }

    public void setWauthor(String wauthor) {
        this.wauthor = wauthor;
    }

    public String getWurl() {
        return wurl;
    }

    public void setWurl(String wurl) {
        this.wurl = wurl;
    }
}
