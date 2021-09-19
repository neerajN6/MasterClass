package com.athrved.masterclass;

public class FoundHelperClass {
    int fimage;
    String ftitle,fdesc;

    public FoundHelperClass() {
    }

    public FoundHelperClass(int fimage, String ftitle, String fdesc) {
        this.fimage = fimage;
        this.ftitle = ftitle;
        this.fdesc = fdesc;
    }

    public int getFimage() {
        return fimage;
    }

    public void setFimage(int fimage) {
        this.fimage = fimage;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }
}
