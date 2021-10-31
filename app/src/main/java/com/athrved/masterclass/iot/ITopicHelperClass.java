package com.athrved.masterclass.iot;

public class ITopicHelperClass {

    String itopicname,ittitle,itauthor;
    int  itimagesmall, itimagebig;

    public ITopicHelperClass() {
    }

    public ITopicHelperClass(String itopicname, String ittitle, String itauthor, int itimagesmall, int itimagebig) {
        this.itopicname = itopicname;
        this.ittitle = ittitle;
        this.itauthor = itauthor;
        this.itimagesmall = itimagesmall;
        this.itimagebig = itimagebig;
    }

    public String getItopicname() {
        return itopicname;
    }

    public void setItopicname(String itopicname) {
        this.itopicname = itopicname;
    }

    public String getIttitle() {
        return ittitle;
    }

    public void setIttitle(String ittitle) {
        this.ittitle = ittitle;
    }

    public String getItauthor() {
        return itauthor;
    }

    public void setItauthor(String itauthor) {
        this.itauthor = itauthor;
    }

    public int getItimagesmall() {
        return itimagesmall;
    }

    public void setItimagesmall(int itimagesmall) {
        this.itimagesmall = itimagesmall;
    }

    public int getItimagebig() {
        return itimagebig;
    }

    public void setItimagebig(int itimagebig) {
        this.itimagebig = itimagebig;
    }
}
