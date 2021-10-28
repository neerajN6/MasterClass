package com.athrved.masterclass.ai;

public class AiTopicHelperClass2 {
    String aiatopicname,aiattitle,aiatauthor;
    int  aiatimagesmall, aiatimagebig;

    public AiTopicHelperClass2() {
    }

    public AiTopicHelperClass2(String aiatopicname, String aiattitle, String aiatauthor, int aiatimagesmall, int aiatimagebig) {
        this.aiatopicname = aiatopicname;
        this.aiattitle = aiattitle;
        this.aiatauthor = aiatauthor;
        this.aiatimagesmall = aiatimagesmall;
        this.aiatimagebig = aiatimagebig;
    }

    public String getAiatopicname() {
        return aiatopicname;
    }

    public void setAiatopicname(String aiatopicname) {
        this.aiatopicname = aiatopicname;
    }

    public String getAiattitle() {
        return aiattitle;
    }

    public void setAiattitle(String aiattitle) {
        this.aiattitle = aiattitle;
    }

    public String getAiatauthor() {
        return aiatauthor;
    }

    public void setAiatauthor(String aiatauthor) {
        this.aiatauthor = aiatauthor;
    }

    public int getAiatimagesmall() {
        return aiatimagesmall;
    }

    public void setAiatimagesmall(int aiatimagesmall) {
        this.aiatimagesmall = aiatimagesmall;
    }

    public int getAiatimagebig() {
        return aiatimagebig;
    }

    public void setAiatimagebig(int aiatimagebig) {
        this.aiatimagebig = aiatimagebig;
    }
}
