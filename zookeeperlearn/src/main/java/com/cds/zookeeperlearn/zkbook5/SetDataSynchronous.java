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
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class SetDataSynchronous implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zk = null;

    public static void main(String[] args)
        throws IOException, InterruptedException, KeeperException {
        String path = "/zk-book";

        zk = new ZooKeeper("207.207.77.62:2181", 5000, new SetDataSynchronous());
        countDownLatch.await();
        zk.create(path, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zk.getData(path, true, null);

        Stat stat = zk.setData(path, "456".getBytes(), -1);
        System.out.println(stat.getCzxid() + ", " + stat.getMzxid() + ", " + stat.getVersion());


        Stat stat2 = zk.setData(path, "456".getBytes(), stat.getVersion());
        System.out.println(stat2.getCzxid() + ", " + stat2.getMzxid() + ", " + stat2.getVersion());

        try {
//            zk.setData(path, "456".getBytes(), stat2.getVersion());
            zk.setData(path, "456".getBytes(), stat.getVersion());
        } catch (KeeperException e) {
            System.out.println("Error: " + e.code() + ", " + e.getMessage());
        }

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override public void process(WatchedEvent event) {
        System.out.println("Receive watched event: " + event);
        if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
            countDownLatch.countDown();
        }
    }
}
