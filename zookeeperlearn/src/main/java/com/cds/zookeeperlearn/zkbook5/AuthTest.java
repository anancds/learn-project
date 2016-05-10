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

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class AuthTest {

    public static final String Path = "/zk-book-auth-test";

    public static void main(String[] args)
        throws IOException, KeeperException, InterruptedException {

        ZooKeeper zooKeeper1 = new ZooKeeper("207.207.77.62:2181", 5000, null);

        zooKeeper1.addAuthInfo("digest", "foo:true".getBytes());

        zooKeeper1
            .create(Path, "init".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);

        ZooKeeper zooKeeper2 = new ZooKeeper("207.207.77.62:2181", 5000, null);
        zooKeeper2.getData(Path, false, null);

    }
}
