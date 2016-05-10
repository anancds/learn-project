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

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class CreateSync implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override public void process(WatchedEvent event) {
        System.out.println("Receive watched event: " + event);
        if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args)
        throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("207.207.77.62:2181", 5000, new CreateSync());
        countDownLatch.await();

        String path1 = zooKeeper
            .create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL);
        System.out.println("Success create znode: " + path1);

        String path2 = zooKeeper
            .create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);

        System.out.println("Success create znode: " + path2);

        Thread.sleep(Integer.MAX_VALUE);

    }
}
