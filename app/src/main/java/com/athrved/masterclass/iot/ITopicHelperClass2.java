package com.athrved.masterclass.iot;

public class ITopicHelperClass2 {

    String iatopicname,iattitle,iatauthor;
    int  iatimagesmall, iatimagebig;

    public ITopicHelperClass2() {
    }

    public ITopicHelperClass2(String iatopicname, String iattitle, String iatauthor, int iatimagesmall, int iatimagebig) {
        this.iatopicname = iatopicname;
        this.iattitle = iattitle;
        this.iatauthor = iatauthor;
        this.iatimagesmall = iatimagesmall;
        this.iatimagebig = iatimagebig;
    }

    public String getIatopicname() {
        return iatopicname;
    }

    public void setIatopicname(String iatopicname) {
        this.iatopicname = iatopicname;
    }

    public String getIattitle() {
        return iattitle;
    }

    public void setIattitle(String iattitle) {
        this.iattitle = iattitle;
    }

    public String getIatauthor() {
        return iatauthor;
    }

    public void setIatauthor(String iatauthor) {
        this.iatauthor = iatauthor;
    }

    public int getIatimagesmall() {
        return iatimagesmall;
    }

    public void setIatimagesmall(int iatimagesmall) {
        this.iatimagesmall = iatimagesmall;
    }

    public int getIatimagebig() {
        return iatimagebig;
    }

    public void setIatimagebig(int iatimagebig) {
        this.iatimagebig = iatimagebig;
    }
}
