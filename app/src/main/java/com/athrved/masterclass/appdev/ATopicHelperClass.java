package com.athrved.masterclass.appdev;

public class ATopicHelperClass {
    String atopicname, attitle, atauthor;
    int atimagesmall, atimagebig;

    public ATopicHelperClass() {
    }

    public ATopicHelperClass(String atopicname, String attitle, String atauthor, int atimagesmall, int atimagebig) {
        this.atopicname = atopicname;
        this.attitle = attitle;
        this.atauthor = atauthor;
        this.atimagesmall = atimagesmall;
        this.atimagebig = atimagebig;
    }

    public String getAtopicname() {
        return atopicname;
    }

    public void setAtopicname(String atopicname) {
        this.atopicname = atopicname;
    }

    public String getAttitle() {
        return attitle;
    }

    public void setAttitle(String attitle) {
        this.attitle = attitle;
    }

    public String getAtauthor() {
        return atauthor;
    }

    public void setAtauthor(String atauthor) {
        this.atauthor = atauthor;
    }

    public int getAtimagesmall() {
        return atimagesmall;
    }

    public void setAtimagesmall(int atimagesmall) {
        this.atimagesmall = atimagesmall;
    }

    public int getAtimagebig() {
        return atimagebig;
    }

    public void setAtimagebig(int atimagebig) {
        this.atimagebig = atimagebig;
    }
}
