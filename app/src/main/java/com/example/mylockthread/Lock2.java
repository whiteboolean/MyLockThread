package com.example.mylockthread;

import java.time.Month;

/**
 *
 * Synchronized锁同步代码块
 */
public class Lock2 {

    private double count = 0 ; //账户余额

    //存钱
    public void addMoney(double money){

        synchronized (this){
            count+=money ;
        }
        System.out.println(System.currentTimeMillis() +  "存进:"+money);

    }

    //取钱
    public void subMoney(double money){
        synchronized(this){
            if (count-money<0){
                System.out.println("余额不足");
                return ;
            }
            count-=money;
        }
        System.out.println(System.currentTimeMillis()+"取出:"+ money);
    }


    //查询
    public void lookMoney(){
        System.out.println("账户余额："+count);
    }
}
