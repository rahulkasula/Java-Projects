package com.easyway2in.mysqldbdemo;

/**
 * Created by rahul on 11/23/2015.
 */
public class Details1 {
    String appliance;
    String powerConsumption;
    String start;
    String end;
    public void setDetails(String x,String y,String z,String a){

        this.appliance=x;
        this.powerConsumption=y;
        this.start=z;
        this.end=a;
    }
    public void setDetails2(String y,String z,String a){
        this.powerConsumption=y;
        this.start=z;
        this.end=a;
    }
    public String getAppliance() {
        return appliance;
    }

    public void setAppliance(String appliance) {
        this.appliance = appliance;
    }

    public String getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(String powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
