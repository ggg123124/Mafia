package com.jikexueyuan.nixi.mafia;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by 超级有节操的逆袭 on 2016/4/19.
 */
public class Skill extends BmobObject{

    private String _objectId;
    private Boolean resistance;
    private Boolean mine;
    private Boolean limit;
    private String camp;
    private String info;
    private String will;
    private Integer box;
    private Boolean inflammable;

    public  void getObjectId(Integer number, final Context context){


        BmobQuery<Gamer> query = new BmobQuery<Gamer>();
        query.addWhereEqualTo("Number", number);

        query.setLimit(50);
//执行查询方法
        query.findObjects(context, new FindListener<Gamer>() {
            @Override
            public void onSuccess(List<Gamer> object) {
                // TODO Auto-generated method stub

                for (Gamer gameScore : object) {
                    //是否夜间无敌
                    resistance = gameScore.getResistance();
                    //获得数据的objectId信息
                    _objectId = gameScore.getObjectId();
                    //警长信息
                    camp = gameScore.getCamp();
                    //探员信息
                    info = gameScore.getInformation();
                    //遗言
                    will = gameScore .getWill();
                    //是否被限制
                    limit = gameScore.getLimit();
                    //是否有陷阱
                    mine = gameScore .getMine();


                }
            }
            @Override
            public void onError(int code, String msg) {
                // TODO Auto-generated method stub

            }
        });




    }
    //杀人动作
    public void Kill(Context context,Integer number){
       getObjectId(number, context);
        Gamer gamer = new Gamer();
        gamer.setAlive(false);
        gamer.update(context, _objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("bmob", "更新成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("bmob", "更新失败：" + s);
            }
        });
    }

    //警长调查
    public String lookCamp(Context context,Integer number){
        getObjectId(number, context);
        return camp;
    }

    //探员调查
    public String lookInfo(Context context,Integer number){
        getObjectId(number,context);
        return info;
    }

    //复活吧！我的勇士！
    public void treatment(Context context,Integer number){
        getObjectId(number, context);
        Gamer gamer = new Gamer();
        gamer.setAlive(true);
        gamer.update(context, _objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("bmob", "更新成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("bmob", "更新失败：" + s);
            }
        });
    }

    //获得遗言
    public String findWill(Context context,Integer number){
        getObjectId(number, context);
        return will;
    }

    //自己是否被限制
    public Boolean limit_(Context context ,Integer number){
        getObjectId(number,context);
        return limit;
    }

    //老司机开车咯
    //在老司机开车指令需要执行两次
    public void bus(Context context,Integer number1,Integer number2){
        getObjectId(number1,context);
        box = number1;
        Gamer gamer = new Gamer();
        gamer.setNumber(number2);
        gamer.update(context, _objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("bmob", "更新成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("bmob", "更新失败：" + s);
            }
        });
        getObjectId(number2, context);
        gamer.setNumber(box);
        gamer.update(context, _objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("bmob", "更新成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("bmob", "更新失败：" + s);
            }
        });
    }

    //夜间无敌
    public void resisance(Context context,Integer number){
        getObjectId(number,context);
        Gamer gamer = new Gamer();
        gamer.setResistance(true);
        gamer.update(context, _objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("bmob", "更新成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("bmob", "更新失败：" + s);
            }
        });
    }

    //限制别人的夜间活动
    public void limlted_sb(Context context,Integer number){
        getObjectId(number,context);
        Gamer gamer = new Gamer();
        gamer.setLimit(true);
        gamer.update(context, _objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("bmob", "更新成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("bmob", "更新失败：" + s);
            }
        });
    }

    //放置陷阱
    public void mines_were_planted(Context context ,Integer number){
        getObjectId(number,context);
        Gamer gamer = new Gamer();
        gamer.setMine(true);
        gamer.update(context, _objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("bmob", "更新成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("bmob", "更新失败：" + s);
            }
        });
    }

    //泼油
   public void burn(Context context,Integer number){
       getObjectId(number,context);
       Gamer gamer = new Gamer();
       gamer.setImmunization(true);
       gamer.update(context, _objectId, new UpdateListener() {
           @Override
           public void onSuccess() {
               Log.i("bmob", "更新成功");
           }

           @Override
           public void onFailure(int i, String s) {
               Log.i("bmob", "更新失败：" + s);
           }
       });
   }

    //点火
    public void fire(final Context context){
        BmobQuery<Gamer> query = new BmobQuery<Gamer>();
        query.addWhereEqualTo("Immunization",true);
        query.setLimit(50);
        query.findObjects(context, new FindListener<Gamer>() {
            @Override
            public void onSuccess(List<Gamer> list) {
                for (Gamer gamer : list) {
                    gamer.getObjectId();

                    gamer.setAlive(false);
                    gamer.update(context, gamer.getObjectId(), new UpdateListener() {
                        @Override
                        public void onSuccess() {
                            Log.i("bmob", "更新成功");
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Log.i("bmob", "更新失败：" + s);
                        }
                    });

                }
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }

    //保护
    //// TODO: 2016/4/23 未完成 
    public void bodyguard(final Context context,Integer number){
        getObjectId(number, context);
        Gamer gamer = new Gamer();
        gamer.setResistance(true);
        gamer.update(context, _objectId, new UpdateListener() {
            @Override
            public void onSuccess() {
                Log.i("bmob", "更新成功");
            }

            @Override
            public void onFailure(int i, String s) {
                Log.i("bmob", "更新失败：" + s);
            }
        });
        BmobQuery<Gamer> query = new BmobQuery<Gamer>();
        query.addWhereEqualTo("interviewed",number);
        query.addWhereEqualTo("Information","有枪");
        query.setLimit(50);
        query.findObjects(context, new FindListener<Gamer>(){
            @Override
            public void onSuccess(List<Gamer> list) {
                for (Gamer gamer1 : list){
                    getObjectId(gamer1.getNumber(),context);
                    Gamer gamer = new Gamer();
                    gamer.setAlive(false);
                    gamer.update(context, _objectId, new UpdateListener() {
                        @Override
                        public void onSuccess() {
                            Log.i("bmob", "更新成功");
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Log.i("bmob", "更新失败：" + s);
                        }
                    });
                }
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }


}
