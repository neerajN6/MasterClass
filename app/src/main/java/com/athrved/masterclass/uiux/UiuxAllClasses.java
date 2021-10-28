package com.athrved.masterclass.uiux;

public class UiuxAllClasses {
    private String utitle;
    private String uchannel;
    private String uauthor;
    private int uimagebig;
    private int uimagesmall;

    public UiuxAllClasses() {
    }

    public UiuxAllClasses(String utitle, String uchannel, String uauthor, int uimagebig, int uimagesmall) {
        this.utitle = utitle;
        this.uchannel = uchannel;
        this.uauthor = uauthor;
        this.uimagebig = uimagebig;
        this.uimagesmall = uimagesmall;
    }

    public String getUtitle() {
        return utitle;
    }

    public void setUtitle(String utitle) {
        this.utitle = utitle;
    }

    public String getUchannel() {
        return uchannel;
    }

    public void setUchannel(String uchannel) {
        this.uchannel = uchannel;
    }

    public String getUauthor() {
        return uauthor;
    }

    public void setUauthor(String uauthor) {
        this.uauthor = uauthor;
    }

    public int getUimagebig() {
        return uimagebig;
    }

    public void setUimagebig(int uimagebig) {
        this.uimagebig = uimagebig;
    }

    public int getUimagesmall() {
        return uimagesmall;
    }

    public void setUimagesmall(int uimagesmall) {
        this.uimagesmall = uimagesmall;
    }
}
