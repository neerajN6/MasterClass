package com.athrved.masterclass;

public class TopicHelperClass {
    int slno;
    String tvideo_id,topicname,ttitle,tauthor;
    int timagebig, timagesmall;

    public TopicHelperClass() {
    }

    public TopicHelperClass(String topicname, String ttitle, String tauthor,  int timagesmall, int timagebig) {

        this.topicname = topicname;
        this.ttitle = ttitle;
        this.tauthor = tauthor;
        this.timagesmall = timagesmall;
        this.timagebig = timagebig;
    }

    public String getTvideo_id() {
        return tvideo_id;
    }

    public void setTvideo_id(String tvideo_id) {
        this.tvideo_id = tvideo_id;
    }

    public int getTimagebig() {
        return timagebig;
    }

    public void setTimagebig(int timagebig) {
        this.timagebig = timagebig;
    }

    public int getTimagesmall() {
        return timagesmall;
    }

    public void setTimagesmall(int timagesmall) {
        this.timagesmall = timagesmall;
    }



    public String getTauthor() {
        return tauthor;
    }

    public void setTauthor(String tauthor) {
        this.tauthor = tauthor;
    }


    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
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
