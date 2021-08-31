package com.athrved.masterclass.uiux;

public class UiuxAllClasses {
    private String title;
    private String channel;
    private String author;
    private int imagebig;
    private int imagesmall;

    public UiuxAllClasses() {
    }

    public UiuxAllClasses(String title, String channel, String author, int imagebig, int imagesmall) {
        this.title = title;
        this.channel = channel;
        this.author = author;
        this.imagebig = imagebig;
        this.imagesmall = imagesmall;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImagebig() {
        return imagebig;
    }

    public void setImagebig(int imagebig) {
        this.imagebig = imagebig;
    }

    public int getImagesmall() {
        return imagesmall;
    }

    public void setImagesmall(int imagesmall) {
        this.imagesmall = imagesmall;
    }
}
