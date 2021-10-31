package com.athrved.masterclass.machdesign;

public class MachTopicHelperClass2 {
    String matopicname,mattitle,matauthor;
    int  matimagesmall, matimagebig;

    public MachTopicHelperClass2() {
    }

    public MachTopicHelperClass2(String matopicname, String mattitle, String matauthor, int matimagesmall, int matimagebig) {
        this.matopicname = matopicname;
        this.mattitle = mattitle;
        this.matauthor = matauthor;
        this.matimagesmall = matimagesmall;
        this.matimagebig = matimagebig;
    }

    public String getMatopicname() {
        return matopicname;
    }

    public void setMatopicname(String matopicname) {
        this.matopicname = matopicname;
    }

    public String getMattitle() {
        return mattitle;
    }

    public void setMattitle(String mattitle) {
        this.mattitle = mattitle;
    }

    public String getMatauthor() {
        return matauthor;
    }

    public void setMatauthor(String matauthor) {
        this.matauthor = matauthor;
    }

    public int getMatimagesmall() {
        return matimagesmall;
    }

    public void setMatimagesmall(int matimagesmall) {
        this.matimagesmall = matimagesmall;
    }

    public int getMatimagebig() {
        return matimagebig;
    }

    public void setMatimagebig(int matimagebig) {
        this.matimagebig = matimagebig;
    }
}
