package com.athrved.masterclass.machdesign;

public class MAllClasses {
    private String mtitle;
    private String mchannel;
    private String mauthor;
    private int mimagebig;
    private int mimagesmall;

    public MAllClasses() {
    }

    public MAllClasses(String mtitle, String mchannel, String mauthor, int mimagebig, int mimagesmall) {
        this.mtitle = mtitle;
        this.mchannel = mchannel;
        this.mauthor = mauthor;
        this.mimagebig = mimagebig;
        this.mimagesmall = mimagesmall;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMchannel() {
        return mchannel;
    }

    public void setMchannel(String mchannel) {
        this.mchannel = mchannel;
    }

    public String getMauthor() {
        return mauthor;
    }

    public void setMauthor(String mauthor) {
        this.mauthor = mauthor;
    }

    public int getMimagebig() {
        return mimagebig;
    }

    public void setMimagebig(int mimagebig) {
        this.mimagebig = mimagebig;
    }

    public int getMimagesmall() {
        return mimagesmall;
    }

    public void setMimagesmall(int mimagesmall) {
        this.mimagesmall = mimagesmall;
    }
}