package com.jikexueyuan.nixi.mafia;

import android.content.Context;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 超级有节操的逆袭 on 2016/4/22.
 */
public class SetUpSever {

    private Integer roll;
    private Boolean sever;
    private Integer number;
    //在这个类中随机一个数字，然后与吧这个随机的数字保存到数据库
    public void Roll(final Context context){
        roll = (int) (Math.random()*100);
        final Gamer gamer = new Gamer();
        gamer.setRoll(roll);
        gamer.save(context, new SaveListener() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure(int i, String s) {

            }
        });


    }

    //根据随机出来的数字来决定玩家楼层并且确定谁是主机
    public void Number(final Context context){
        final Gamer gamer = new Gamer();
        BmobQuery<Gamer> query = new BmobQuery<Gamer>();
        query.addWhereLessThan("Roll",roll);
        query.findObjects(context, new FindListener<Gamer>() {
            @Override
            public void onSuccess(List<Gamer> object) {
                if (object.size() == 0){
                    sever = true;
                }
                gamer.setNumber(object.size());
                gamer.save(context, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        ////// TODO: 2016/4/22
                    }

                    @Override
                    public void onFailure(int i, String s) {

                    }
                });
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }

    public Boolean getSever() {
        return sever;
    }
}
