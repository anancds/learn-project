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

public class CreateAsynchronous implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override public void process(WatchedEvent event) {
        System.out.println("Receive watched event: " + event);
        if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args)
        throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("207.207.77.62:2181", 5000, new CreateAsynchronous());
        countDownLatch.await();

        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
            CreateMode.EPHEMERAL, new IStringCallback(), "I am context.");

        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
            CreateMode.EPHEMERAL, new IStringCallback(), "I am context.");

        zooKeeper.create("/zk-test-ephemeral-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
            CreateMode.EPHEMERAL_SEQUENTIAL, new IStringCallback(), "I am context.");

        Thread.sleep(Integer.MAX_VALUE);
    }

    private static class IStringCallback implements AsyncCallback.StringCallback {
        @Override public void processResult(int rc, String path, Object ctx, String name) {

            System.out.println(
                "Create path result：[" + rc + ", " + path + ", " + ctx + ", real path name " + ": "
                    + name);
        }
    }
}
