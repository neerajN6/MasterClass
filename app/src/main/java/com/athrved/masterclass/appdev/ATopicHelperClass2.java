package com.athrved.masterclass.appdev;

public class ATopicHelperClass2 {

    String appatopicname,appattitle,appatauthor;
    int  appatimagesmall, appatimagebig;

    public ATopicHelperClass2() {
    }

    public ATopicHelperClass2(String appatopicname, String appattitle, String appatauthor, int appatimagesmall, int appatimagebig) {
        this.appatopicname = appatopicname;
        this.appattitle = appattitle;
        this.appatauthor = appatauthor;
        this.appatimagesmall = appatimagesmall;
        this.appatimagebig = appatimagebig;
    }

    public String getAppatopicname() {
        return appatopicname;
    }

    public void setAppatopicname(String appatopicname) {
        this.appatopicname = appatopicname;
    }

    public String getAppattitle() {
        return appattitle;
    }

    public void setAppattitle(String appattitle) {
        this.appattitle = appattitle;
    }

    public String getAppatauthor() {
        return appatauthor;
    }

    public void setAppatauthor(String appatauthor) {
        this.appatauthor = appatauthor;
    }

    public int getAppatimagesmall() {
        return appatimagesmall;
    }

    public void setAppatimagesmall(int appatimagesmall) {
        this.appatimagesmall = appatimagesmall;
    }

    public int getAppatimagebig() {
        return appatimagebig;
    }

    public void setAppatimagebig(int appatimagebig) {
        this.appatimagebig = appatimagebig;
    }
}
