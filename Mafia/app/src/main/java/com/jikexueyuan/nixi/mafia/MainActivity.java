package com.jikexueyuan.nixi.mafia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cn.bmob.newim.BmobIM;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NewIM初始化
        BmobIM.init(this);
        //注册消息接收器
        //// TODO: 2016/4/23 这个地方注册的可能有问题，如果在之后的开发中出现消息接收器异常需要检查这里
        BmobIM.registerDefaultMessageHandler(new MessageHandler());
    }
}
