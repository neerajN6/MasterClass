package com.athrved.masterclass;

public class topicHelperClass {
    int slno;
    String topicname;

    public topicHelperClass() {
    }

    public topicHelperClass(int slno, String topicname) {
        this.slno = slno;
        this.topicname = topicname;
    }

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }
}
