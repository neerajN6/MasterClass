package com.athrved.masterclass;

public class MenHelperClass {
    int image;
    String name,des;

    public MenHelperClass() {
    }

    public MenHelperClass(int image,String name, String des) {
        this.image = image;
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
