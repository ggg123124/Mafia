package com.jikexueyuan.nixi.mafia;

import cn.bmob.v3.BmobObject;

/**
 * Created by 超级有节操的逆袭 on 2016/4/19.
 */
public class Gamer extends BmobObject{
    private Boolean Alive;
    private Boolean Resistance;
    private Boolean Mine;
    private Boolean  Immunization;
    private Boolean limit;
    private String Will;
    private String GamerName;
    private String Camp;
    private String Type;
    private String Information;
    private Integer Number;
    private Boolean Inflammable;



    public Boolean getAlive() {
        return Alive;
    }

    public Boolean getInflammable() {
        return Inflammable;
    }

    public void setInflammable(Boolean inflammable) {
        Inflammable = inflammable;
    }

    public Boolean getMine() {
        return Mine;
    }

    public Boolean getLimit() {
        return limit;
    }

    public String getWill() {
        return Will;
    }

    public Boolean getImmunization() {
        return Immunization;
    }

    public Boolean getResistance() {
        return Resistance;
    }

    public String getInformation() {
        return Information;
    }

    public String getGamerName() {
        return GamerName;
    }

    public String getCamp() {
        return Camp;
    }

    public String getType() {
        return Type;
    }

    public Integer getNumber() {
        return Number;
    }


    public void setAlive(Boolean alive) {
        Alive = alive;
    }

    public void setMine(Boolean mine) {
        Mine = mine;
    }

    public void setCamp(String camp) {
        Camp = camp;
    }

    public void setWill(String will) {
        Will = will;
    }

    public void setGamerName(String gamerName) {
        GamerName = gamerName;
    }

    public void setLimit(Boolean limit) {
        this.limit = limit;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public void setResistance(Boolean resistance) {
        Resistance = resistance;
    }

    public void setImmunization(Boolean immunization) {
        Immunization = immunization;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setInformation(String information) {
        Information = information;
    }
}
