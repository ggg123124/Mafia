package com.jikexueyuan.nixi.mafia;

import cn.bmob.v3.BmobObject;

/**
 * Created by 超级有节操的逆袭 on 2016/4/21.
 */
public class Night extends BmobObject{
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
}
