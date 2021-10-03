package com.athrved.masterclass.webdevelopment;

public class WebTopicHelperClass {
    String wtopicname,wttitle,wtauthor;
    int  wtimagesmall, wtimagebig;

    public WebTopicHelperClass() {
    }

    public WebTopicHelperClass(String wtopicname, String wttitle, String wtauthor, int wtimagesmall, int wtimagebig) {
        this.wtopicname = wtopicname;
        this.wttitle = wttitle;
        this.wtauthor = wtauthor;
        this.wtimagesmall = wtimagesmall;
        this.wtimagebig = wtimagebig;
    }

    public String getWtopicname() {
        return wtopicname;
    }

    public void setWtopicname(String wtopicname) {
        this.wtopicname = wtopicname;
    }

    public String getWttitle() {
        return wttitle;
    }

    public void setWttitle(String wttitle) {
        this.wttitle = wttitle;
    }

    public String getWtauthor() {
        return wtauthor;
    }

    public void setWtauthor(String wtauthor) {
        this.wtauthor = wtauthor;
    }

    public int getWtimagesmall() {
        return wtimagesmall;
    }

    public void setWtimagesmall(int wtimagesmall) {
        this.wtimagesmall = wtimagesmall;
    }

    public int getWtimagebig() {
        return wtimagebig;
    }

    public void setWtimagebig(int wtimagebig) {
        this.wtimagebig = wtimagebig;
    }
}
