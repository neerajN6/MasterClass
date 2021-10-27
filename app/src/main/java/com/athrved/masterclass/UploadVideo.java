package com.athrved.masterclass;

public class UploadVideo {

    private int CourseId;
    private int Paid;
    private long SlNo;
    private String VideoTitle;
    private int TopicId;
    private String VideoId;

    public UploadVideo() {
        //Empty Constructor
    }

    public UploadVideo(int courseId, int paid, long slno, String videoTitle, int topicId, String videoId) {


        if (videoTitle.trim().equals("")) {
            videoTitle = "";
        }

        CourseId = courseId;
        Paid = paid;
        SlNo = slno;
        VideoTitle = videoTitle;
        TopicId = topicId;
        VideoId = videoId;
    }

    public UploadVideo(String toString) {
    }


    public int getcourseId_v() { return CourseId; }

    public void setcourseId_v(int courseId) { CourseId = courseId; }

    public int getpaid() { return Paid; }

    public void setpaid(int paid) { Paid = paid; }

    public long getslno() { return SlNo; }

    public void setslno(long slNo) { SlNo = slNo; }

    public String gettitle_video() {
        return VideoTitle;
    }

    public void settitle_video(String videoTitle) {
        VideoTitle = videoTitle;
    }

    public int gettopicid() {
        return TopicId;
    }

    public void settopicid(int topicId) {
        TopicId = topicId;
    }

    public String getvideo_Id() {
        return VideoId;
    }

    public void setvideo_Id(String videoId) {
        VideoId = videoId;
    }
}
