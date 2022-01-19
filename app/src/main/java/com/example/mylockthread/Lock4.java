package com.example.mylockthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 使用重入锁实现线程同步
 * ReentrantLock类是可重入、互斥、实现了Lock接口的锁， 它与使用synchronized方法和快具有相同的基本行为和语义，并且扩展了其能力。
 */
public class Lock4 {
        private Lock lock  = new ReentrantLock();

        public double count = 0;//账户余额

}
