package com.athrved.masterclass;

public class PopHelperClass {
    int imagebig, imagesmall1,imagesmall2;
    String title, topic,author;

    public PopHelperClass() {
    }

    public PopHelperClass(int imagebig, int imagesmall1, int imagesmall2, String title, String topic, String author) {
        this.imagebig = imagebig;
        this.imagesmall1 = imagesmall1;
        this.imagesmall2 = imagesmall2;
        this.title = title;
        this.topic = topic;
        this.author = author;
    }

    public int getImagebig() {
        return imagebig;
    }

    public void setImagebig(int imagebig) {
        this.imagebig = imagebig;
    }

    public int getImagesmall1() {
        return imagesmall1;
    }

    public void setImagesmall1(int imagesmall1) {
        this.imagesmall1 = imagesmall1;
    }

    public int getImagesmall2() {
        return imagesmall2;
    }

    public void setImagesmall2(int imagesmall2) {
        this.imagesmall2 = imagesmall2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
