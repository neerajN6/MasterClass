package com.athrved.masterclass.ai;

public class AiFreeHelperClass {
    int aiimagesmall1,aiimagesmall2;
    String aititle, aitopic,aiauthor;

    public AiFreeHelperClass() {
    }

    public AiFreeHelperClass(int aiimagesmall1, int aiimagesmall2, String aititle, String aitopic, String aiauthor) {
        this.aiimagesmall1 = aiimagesmall1;
        this.aiimagesmall2 = aiimagesmall2;
        this.aititle = aititle;
        this.aitopic = aitopic;
        this.aiauthor = aiauthor;
    }

    public int getAiimagesmall1() {
        return aiimagesmall1;
    }

    public void setAiimagesmall1(int aiimagesmall1) {
        this.aiimagesmall1 = aiimagesmall1;
    }

    public int getAiimagesmall2() {
        return aiimagesmall2;
    }

    public void setAiimagesmall2(int aiimagesmall2) {
        this.aiimagesmall2 = aiimagesmall2;
    }

    public String getAititle() {
        return aititle;
    }

    public void setAititle(String aititle) {
        this.aititle = aititle;
    }

    public String getAitopic() {
        return aitopic;
    }

    public void setAitopic(String aitopic) {
        this.aitopic = aitopic;
    }

    public String getAiauthor() {
        return aiauthor;
    }

    public void setAiauthor(String aiauthor) {
        this.aiauthor = aiauthor;
    }
}
