package com.athrved.masterclass.uiux;

public class FreeHelperClass {
    int imagesmall1,imagesmall2;
    String title, topic,author;

    public FreeHelperClass() {
    }

    public FreeHelperClass(int imagesmall1, int imagesmall2, String title, String topic, String author) {

        this.imagesmall1 = imagesmall1;
        this.imagesmall2 = imagesmall2;
        this.title = title;
        this.topic = topic;
        this.author = author;
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
