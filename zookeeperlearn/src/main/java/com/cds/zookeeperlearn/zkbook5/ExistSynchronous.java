/**
 * Copyright (c) 2015, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :learn-project
 * Package Name :com.uniview.zookeeperlearn.zkbook5
 * Date Created :2016/3/29
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/3/29      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.zookeeperlearn.zkbook5;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ExistSynchronous implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zk;

    public static void main(String[] args)
        throws IOException, InterruptedException, KeeperException {
        String path = "/zk-book";

        zk = new ZooKeeper("207.207.77.62:2181", 500000, new ExistSynchronous());
        countDownLatch.await();
        zk.exists(path, true);

        zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.setData(path, "123".getBytes(), -1);
        zk.create(path + "/c1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zk.delete(path + "/c1", -1);
        zk.delete(path, -1);
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override public void process(WatchedEvent event) {

        try {
            if (Event.KeeperState.SyncConnected == event.getState() && null == event.getPath()) {
                System.out.println("count down");
                countDownLatch.countDown();
            } else if (Event.EventType.NodeCreated == event.getType()) {
                System.out.println("Node(" + event.getPath() + ")Created");
                zk.exists(event.getPath(), true);
            } else if (Event.EventType.NodeDeleted == event.getType()) {
                System.out.println("Node(" + event.getPath() + ")Deleted");
                zk.exists(event.getPath(), true);
            } else if (Event.EventType.NodeDataChanged == event.getType()) {
                System.out.println("Node(" + event.getPath() + ")DataChanged");
                zk.exists(event.getPath(), true);
            }
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }

    }
}
