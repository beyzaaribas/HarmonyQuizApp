package com.harmonyquizapp;

public class tutorialModel {


    String Information;
    String oInfo;

    public tutorialModel(String information, String oInfo) {
        Information = information;
        this.oInfo = oInfo;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }

    public String getoInfo() {
        return oInfo;
    }

    public void setoInfo(String oInfo) {
        this.oInfo = oInfo;
    }

}
