/**
 * Copyright (c) 2015, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :learn-project
 * Package Name :com.uniview.zookeeperlearn.zkbook5
 * Date Created :2016/3/25
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/3/25      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.zookeeperlearn.zkbook5;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreateSessionId implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("207.207.77.62:2181", 5000, new CreateSessionId());
        System.out.println(System.currentTimeMillis());
        System.out.println(zooKeeper.getState());
        countDownLatch.await();

        long sessionId = zooKeeper.getSessionId();
        byte[] passwd = zooKeeper.getSessionPasswd();
        zooKeeper =
            new ZooKeeper("207.207.77.62:2181", 5000, new CreateSessionId(), 1L, "test".getBytes());

        zooKeeper = new ZooKeeper("207.207.77.62:2181", 5000, new CreateSessionId(), sessionId, passwd);

        Thread.sleep(Integer.MAX_VALUE);

    }

    @Override public void process(WatchedEvent event) {
        System.out.printf("Receive watched event: " + event);
        System.out.println(System.currentTimeMillis());
        if (Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }
}
