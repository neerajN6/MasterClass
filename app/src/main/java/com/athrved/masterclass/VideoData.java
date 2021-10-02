package com.athrved.masterclass;

public class VideoData {
    String video_Id, title_video, authors;
    int courseId_v,paid,slno,topicid;

    public VideoData() {
    }

    public VideoData(String video_Id, String title_video, int courseId_v,int paid,int slno, int topicid, String authors) {
        this.video_Id = video_Id;
        this.title_video = title_video;
        this.courseId_v = courseId_v;
        this.paid = paid;
        this.slno=slno;
        this.topicid=topicid;
        this.authors=authors;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public String getVideo_Id() {
        return video_Id;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public void setVideo_Id(String video_Id) {
        this.video_Id = video_Id;
    }

    public String getTitle_video() {
        return title_video;
    }

    public void setTitle_video(String title_video) {
        this.title_video = title_video;
    }

    public int getCourseId_v() {
        return courseId_v;
    }

    public void setCourseId_v(int courseId_v) {
        this.courseId_v = courseId_v;
    }
}
