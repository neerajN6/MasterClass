package com.athrved.masterclass.uiux;

public class UiuxTopicHelperClass {
    String utopicname,uttitle,utauthor;
    int  utimagesmall, utimagebig;

    public UiuxTopicHelperClass() {
    }

    public UiuxTopicHelperClass(String utopicname, String uttitle, String utauthor, int utimagesmall, int utimagebig) {
        this.utopicname = utopicname;
        this.uttitle = uttitle;
        this.utauthor = utauthor;
        this.utimagesmall = utimagesmall;
        this.utimagebig = utimagebig;
    }

    public String getUtopicname() {
        return utopicname;
    }

    public void setUtopicname(String utopicname) {
        this.utopicname = utopicname;
    }

    public String getUttitle() {
        return uttitle;
    }

    public void setUttitle(String uttitle) {
        this.uttitle = uttitle;
    }

    public String getUtauthor() {
        return utauthor;
    }

    public void setUtauthor(String utauthor) {
        this.utauthor = utauthor;
    }

    public int getUtimagesmall() {
        return utimagesmall;
    }

    public void setUtimagesmall(int utimagesmall) {
        this.utimagesmall = utimagesmall;
    }

    public int getUtimagebig() {
        return utimagebig;
    }

    public void setUtimagebig(int utimagebig) {
        this.utimagebig = utimagebig;
    }
}
