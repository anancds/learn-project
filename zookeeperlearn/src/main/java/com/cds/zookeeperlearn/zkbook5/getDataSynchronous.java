/**
 * Copyright (c) 2015, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :learn-project
 * Package Name :com.uniview.zookeeperlearn.zkbook5
 * Date Created :2016/3/28
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/3/28      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.zookeeperlearn.zkbook5;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class getDataSynchronous implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();

    @Override public void process(WatchedEvent event) {
        System.out.println("the event is :" + event);

        if (Event.KeeperState.SyncConnected == event.getState()) {
            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                countDownLatch.countDown();
            } else if (event.getType() == Event.EventType.NodeDataChanged) {
                try {
                    System.out.println(new String(zk.getData(event.getPath(), true, stat)));
                    System.out.println(
                        stat.getCzxid() + ", " + stat.getMzxid() + ", " + stat.getVersion());
                } catch (InterruptedException | KeeperException e) {
                }
            }
        }
    }

    public static void main(String[] args)
        throws IOException, InterruptedException, KeeperException {
        String path = "/zk-book";

        zk = new ZooKeeper("207.207.77.62:2181", 5000, new getDataSynchronous());
        countDownLatch.await();
        zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(path + "/c1", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
            CreateMode.EPHEMERAL);
        System.out.println(new String(zk.getData("/zk-book/c1", true, stat)));
        System.out.println(stat.getCzxid() + ", " + stat.getMzxid() + ", " + stat.getVersion());
        zk.setData("/zk-book/c1", "234".getBytes(), -1);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
