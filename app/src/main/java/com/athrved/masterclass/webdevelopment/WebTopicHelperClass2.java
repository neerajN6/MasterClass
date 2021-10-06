package com.athrved.masterclass.webdevelopment;

public class WebTopicHelperClass2 {
    String watopicname,wattitle,watauthor;
    int  watimagesmall, watimagebig;

    public WebTopicHelperClass2() {
    }

    public WebTopicHelperClass2(String watopicname, String wattitle, String watauthor, int watimagesmall, int watimagebig) {
        this.watopicname = watopicname;
        this.wattitle = wattitle;
        this.watauthor = watauthor;
        this.watimagesmall = watimagesmall;
        this.watimagebig = watimagebig;
    }

    public String getWatopicname() {
        return watopicname;
    }

    public void setWatopicname(String watopicname) {
        this.watopicname = watopicname;
    }

    public String getWattitle() {
        return wattitle;
    }

    public void setWattitle(String wattitle) {
        this.wattitle = wattitle;
    }

    public String getWatauthor() {
        return watauthor;
    }

    public void setWatauthor(String watauthor) {
        this.watauthor = watauthor;
    }

    public int getWatimagesmall() {
        return watimagesmall;
    }

    public void setWatimagesmall(int watimagesmall) {
        this.watimagesmall = watimagesmall;
    }

    public int getWatimagebig() {
        return watimagebig;
    }

    public void setWatimagebig(int watimagebig) {
        this.watimagebig = watimagebig;
    }
}
