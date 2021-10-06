package com.athrved.masterclass.machdesign;

public class MachTopicHelperClass {
    String mtopicname,mttitle,mtauthor, mvideoid;
    int  mtimagesmall, mtimagebig; //m for mach, ai for ai, a for app

    public MachTopicHelperClass() {
    }

    public MachTopicHelperClass(String mtopicname, String mttitle, String mtauthor, int mtimagesmall, int mtimagebig, String mvideoid) {
        this.mtopicname = mtopicname;
        this.mttitle = mttitle;
        this.mtauthor = mtauthor;
        this.mtimagesmall = mtimagesmall;
        this.mtimagebig = mtimagebig;
        this.mvideoid=mvideoid;
    }

    public String getMvideoid() {
        return mvideoid;
    }

    public void setMvideoid(String mvideoid) {
        this.mvideoid = mvideoid;
    }

    public String getMtopicname() {
        return mtopicname;
    }

    public void setMtopicname(String mtopicname) {
        this.mtopicname = mtopicname;
    }

    public String getMttitle() {
        return mttitle;
    }

    public void setMttitle(String mttitle) {
        this.mttitle = mttitle;
    }

    public String getMtauthor() {
        return mtauthor;
    }

    public void setMtauthor(String mtauthor) {
        this.mtauthor = mtauthor;
    }

    public int getMtimagesmall() {
        return mtimagesmall;
    }

    public void setMtimagesmall(int mtimagesmall) {
        this.mtimagesmall = mtimagesmall;
    }

    public int getMtimagebig() {
        return mtimagebig;
    }

    public void setMtimagebig(int mtimagebig) {
        this.mtimagebig = mtimagebig;
    }
}
