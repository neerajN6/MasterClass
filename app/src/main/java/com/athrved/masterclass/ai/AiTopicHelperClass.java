package com.athrved.masterclass.ai;

public class AiTopicHelperClass {
    String aitopicname, aittitle, aitauthor;
    int aitimagesmall, aitimagebig;

    public AiTopicHelperClass() {
    }

    public AiTopicHelperClass(String aitopicname, String aittitle, String aitauthor, int aitimagesmall, int aitimagebig) {
        this.aitopicname = aitopicname;
        this.aittitle = aittitle;
        this.aitauthor = aitauthor;
        this.aitimagesmall = aitimagesmall;
        this.aitimagebig = aitimagebig;
    }

    public String getAitopicname() {
        return aitopicname;
    }

    public void setAitopicname(String aitopicname) {
        this.aitopicname = aitopicname;
    }

    public String getAittitle() {
        return aittitle;
    }

    public void setAittitle(String aittitle) {
        this.aittitle = aittitle;
    }

    public String getAitauthor() {
        return aitauthor;
    }

    public void setAitauthor(String aitauthor) {
        this.aitauthor = aitauthor;
    }

    public int getAitimagesmall() {
        return aitimagesmall;
    }

    public void setAitimagesmall(int aitimagesmall) {
        this.aitimagesmall = aitimagesmall;
    }

    public int getAitimagebig() {
        return aitimagebig;
    }

    public void setAitimagebig(int aitimagebig) {
        this.aitimagebig = aitimagebig;
    }
}

