package com.jikexueyuan.nixi.mafia;

import cn.bmob.v3.BmobObject;

/**
 * Created by 超级有节操的逆袭 on 2016/4/19.
 */
public class Gamer extends BmobObject{
    //是否是活人
    private Boolean Alive;
    //是否夜间无敌
    private Boolean Resistance;
    //是否被放置过陷阱
    private Boolean Mine;
    //是否侦察免疫
    private Boolean  Immunization;
    //是否被限制
    private Boolean limit;
    //遗嘱
    private String Will;
    //玩家设置的名字
    private String GamerName;
    //阵营（警长调查信息）
    private String Camp;
    //角色类型
    private String Type;
    //探员调查信息
    private String Information;
    //楼层
    private Integer Number;
    //是否被泼油
    private Boolean Inflammable;
    //在开局的时候给云数据库一个随机数，通过排序来决定谁是主机
    private Integer Roll;



    //访问目标
    private Integer interviewed[];
    //被哪些人访问过
    private Integer accessed[];

    public Integer[] getAccessed() {
        return accessed;
    }

    public Integer[] getInterviewed() {
        return interviewed;
    }

    public void setAccessed(Integer[] accessed) {
        this.accessed = accessed;
    }

    public void setInterviewed(Integer[] interviewed) {
        this.interviewed = interviewed;
    }
    public Boolean getAlive() {
        return Alive;
    }

    public Integer getRoll() {
        return Roll;
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

    public void setRoll(Integer roll) {
        Roll = roll;
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
