package com.athrved.masterclass.webdevelopment;

public class WebAllCLasses {
    private String wtitle;
    private String wchannel;
    private String wauthor;
    private int wimagebig;
    private int wimagesmall;

    public WebAllCLasses() {
    }

    public WebAllCLasses(String wtitle, String wchannel, String wauthor, int wimagebig, int wimagesmall) {
        this.wtitle = wtitle;
        this.wchannel = wchannel;
        this.wauthor = wauthor;
        this.wimagebig = wimagebig;
        this.wimagesmall = wimagesmall;
    }

    public String getWtitle() {
        return wtitle;
    }

    public void setWtitle(String wtitle) {
        this.wtitle = wtitle;
    }

    public String getWchannel() {
        return wchannel;
    }

    public void setWchannel(String wchannel) {
        this.wchannel = wchannel;
    }

    public String getWauthor() {
        return wauthor;
    }

    public void setWauthor(String wauthor) {
        this.wauthor = wauthor;
    }

    public int getWimagebig() {
        return wimagebig;
    }

    public void setWimagebig(int wimagebig) {
        this.wimagebig = wimagebig;
    }

    public int getWimagesmall() {
        return wimagesmall;
    }

    public void setWimagesmall(int wimagesmall) {
        this.wimagesmall = wimagesmall;
    }
}
