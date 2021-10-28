package com.athrved.masterclass.uiux;

public class UiuxTopicHelperClass2 {
    String uatopicname,uattitle,uatauthor;
    int  uatimagesmall, uatimagebig;

    public UiuxTopicHelperClass2() {
    }

    public UiuxTopicHelperClass2(String uatopicname, String uattitle, String uatauthor, int uatimagesmall, int uatimagebig) {
        this.uatopicname = uatopicname;
        this.uattitle = uattitle;
        this.uatauthor = uatauthor;
        this.uatimagesmall = uatimagesmall;
        this.uatimagebig = uatimagebig;
    }

    public String getUatopicname() {
        return uatopicname;
    }

    public void setUatopicname(String uatopicname) {
        this.uatopicname = uatopicname;
    }

    public String getUattitle() {
        return uattitle;
    }

    public void setUattitle(String uattitle) {
        this.uattitle = uattitle;
    }

    public String getUatauthor() {
        return uatauthor;
    }

    public void setUatauthor(String uatauthor) {
        this.uatauthor = uatauthor;
    }

    public int getUatimagesmall() {
        return uatimagesmall;
    }

    public void setUatimagesmall(int uatimagesmall) {
        this.uatimagesmall = uatimagesmall;
    }

    public int getUatimagebig() {
        return uatimagebig;
    }

    public void setUatimagebig(int uatimagebig) {
        this.uatimagebig = uatimagebig;
    }
}
