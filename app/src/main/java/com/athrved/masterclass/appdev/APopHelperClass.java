package com.athrved.masterclass.appdev;

public class APopHelperClass {
    int aimagebig, aimagesmall1,aimagesmall2;
    String atitle, atopic,aauthor,aurl;

    public APopHelperClass() {
    }

    public APopHelperClass(int aimagebig, int aimagesmall1, int aimagesmall2, String atitle, String atopic, String aauthor, String aurl) {
        this.aimagebig = aimagebig;
        this.aimagesmall1 = aimagesmall1;
        this.aimagesmall2 = aimagesmall2;
        this.atitle = atitle;
        this.atopic = atopic;
        this.aauthor = aauthor;
        this.aurl = aurl;
    }

    public int getAimagebig() {
        return aimagebig;
    }

    public void setAimagebig(int aimagebig) {
        this.aimagebig = aimagebig;
    }

    public int getAimagesmall1() {
        return aimagesmall1;
    }

    public void setAimagesmall1(int aimagesmall1) {
        this.aimagesmall1 = aimagesmall1;
    }

    public int getAimagesmall2() {
        return aimagesmall2;
    }

    public void setAimagesmall2(int aimagesmall2) {
        this.aimagesmall2 = aimagesmall2;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getAtopic() {
        return atopic;
    }

    public void setAtopic(String atopic) {
        this.atopic = atopic;
    }

    public String getAauthor() {
        return aauthor;
    }

    public void setAauthor(String aauthor) {
        this.aauthor = aauthor;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }
}
