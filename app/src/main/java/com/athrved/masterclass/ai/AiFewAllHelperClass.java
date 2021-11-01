package com.athrved.masterclass.ai;

public class AiFewAllHelperClass {
    private String aititle;
    private String aichannel;
    private String aiauthor;
    private int aiimagebig;
    private int aiimagesmall;

    public AiFewAllHelperClass() {
    }

    public AiFewAllHelperClass(int aiimagebig, int aiimagesmall, String aititle, String aichannel, String aiauthor) {
        this.aititle = aititle;
        this.aichannel = aichannel;
        this.aiauthor = aiauthor;
        this.aiimagebig = aiimagebig;
        this.aiimagesmall = aiimagesmall;
    }

    public String getAititle() {
        return aititle;
    }

    public void setAititle(String aititle) {
        this.aititle = aititle;
    }

    public String getAichannel() {
        return aichannel;
    }

    public void setAichannel(String aichannel) {
        this.aichannel = aichannel;
    }

    public String getAiauthor() {
        return aiauthor;
    }

    public void setAiauthor(String aiauthor) {
        this.aiauthor = aiauthor;
    }

    public int getAiimagebig() {
        return aiimagebig;
    }

    public void setAiimagebig(int aiimagebig) {
        this.aiimagebig = aiimagebig;
    }

    public int getAiimagesmall() {
        return aiimagesmall;
    }

    public void setAiimagesmall(int aiimagesmall) {
        this.aiimagesmall = aiimagesmall;
    }
}
