package com.athrved.masterclass.ai;

public class AiMenHelperClass {
    int aiimage;
    String ainame,aides;

    public AiMenHelperClass() {
    }

    public AiMenHelperClass(int aiimage, String ainame, String aides) {
        this.aiimage = aiimage;
        this.ainame = ainame;
        this.aides = aides;
    }

    public int getAiimage() {
        return aiimage;
    }

    public void setAiimage(int aiimage) {
        this.aiimage = aiimage;
    }

    public String getAiname() {
        return ainame;
    }

    public void setAiname(String ainame) {
        this.ainame = ainame;
    }

    public String getAides() {
        return aides;
    }

    public void setAides(String aides) {
        this.aides = aides;
    }
}
