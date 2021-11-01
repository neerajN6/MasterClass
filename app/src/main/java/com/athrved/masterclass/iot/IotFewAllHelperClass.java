package com.athrved.masterclass.iot;

public class IotFewAllHelperClass {
    private String ititle;
    private String ichannel;
    private String iauthor;
    private int iimagebig;
    private int iimagesmall;

    public IotFewAllHelperClass() {
    }

    public IotFewAllHelperClass(int iimagebig,int iimagesmall, String ititle, String ichannel, String iauthor) {
        this.ititle = ititle;
        this.ichannel = ichannel;
        this.iauthor = iauthor;
        this.iimagebig = iimagebig;
        this.iimagesmall = iimagesmall;
    }

    public String getItitle() {
        return ititle;
    }

    public void setItitle(String ititle) {
        this.ititle = ititle;
    }

    public String getIchannel() {
        return ichannel;
    }

    public void setIchannel(String ichannel) {
        this.ichannel = ichannel;
    }

    public String getIauthor() {
        return iauthor;
    }

    public void setIauthor(String iauthor) {
        this.iauthor = iauthor;
    }

    public int getIimagebig() {
        return iimagebig;
    }

    public void setIimagebig(int iimagebig) {
        this.iimagebig = iimagebig;
    }

    public int getIimagesmall() {
        return iimagesmall;
    }

    public void setIimagesmall(int iimagesmall) {
        this.iimagesmall = iimagesmall;
    }
}
