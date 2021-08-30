package com.athrved.masterclass;

public class FewAllHelperClass {
    int ImageBig,ImageSmall;
    String title, channel,Author;

    public FewAllHelperClass() {
    }

    public FewAllHelperClass(int imageBig, int imageSmall, String title, String channel, String author) {
        ImageBig = imageBig;
        ImageSmall = imageSmall;
        this.title = title;
        this.channel = channel;
        Author = author;
    }

    public int getImageBig() {
        return ImageBig;
    }

    public void setImageBig(int imageBig) {
        ImageBig = imageBig;
    }

    public int getImageSmall() {
        return ImageSmall;
    }

    public void setImageSmall(int imageSmall) {
        ImageSmall = imageSmall;
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
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
