package com.athrved.masterclass.appdev;

public class AFewAllHelperClass {
    private String atitle;
    private String achannel;
    private String aauthor;
    private int aimagebig;
    private int aimagesmall;

    public AFewAllHelperClass() {
    }

    public AFewAllHelperClass(int aimagebig, int aimagesmall,String atitle, String achannel, String aauthor) {
        this.atitle = atitle;
        this.achannel = achannel;
        this.aauthor = aauthor;
        this.aimagebig = aimagebig;
        this.aimagesmall = aimagesmall;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getAchannel() {
        return achannel;
    }

    public void setAchannel(String achannel) {
        this.achannel = achannel;
    }

    public String getAauthor() {
        return aauthor;
    }

    public void setAauthor(String aauthor) {
        this.aauthor = aauthor;
    }

    public int getAimagebig() {
        return aimagebig;
    }

    public void setAimagebig(int aimagebig) {
        this.aimagebig = aimagebig;
    }

    public int getAimagesmall() {
        return aimagesmall;
    }

    public void setAimagesmall(int aimagesmall) {
        this.aimagesmall = aimagesmall;
    }
}
