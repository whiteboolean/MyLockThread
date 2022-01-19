package com.example.mylockthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 使用重入锁实现线程同步
 * ReentrantLock类是可重入、互斥、实现了Lock接口的锁， 它与使用synchronized方法和快具有相同的基本行为和语义，并且扩展了其能力。
 * https://blog.csdn.net/qq_40551367/article/details/89414446
 *
 *
 */
public class Lock4 {
        private Lock lock  = new ReentrantLock();

        public double count = 0;//账户余额

        // 存钱
        public void addMoney(int money) {
                lock.lock();//上锁
                try{
                        count += money;
                        System.out.println(System.currentTimeMillis() + "存进：" + money);

                }finally{
                        lock.unlock();//解锁
                }
        }


        // 取钱
        public void subMoney(int money) {
                lock.lock();
                try{

                        if (count - money < 0) {
                                System.out.println("余额不足");
                                return;
                        }
                        count -= money;
                        System.out.println(+System.currentTimeMillis() + "取出：" + money);
                }finally{
                        lock.unlock();
                }
        }

        // 查询
        public void lookMoney() {
                System.out.println("账户余额：" + count);
        }

}
