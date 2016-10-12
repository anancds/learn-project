/**
 * Copyright (c) 2016, zhejiang Unview Technologies Co., Ltd.
 * All rights reserved.
 * <http://www.uniview.com/>
 * -----------------------------------------------------------
 * Product      :BigData
 * Module Name  :
 * Project Name :learn-project
 * Package Name :com.cds.zookeeperlearn.curator
 * Date Created :2016/10/12
 * Creator      :c02132
 * Description  :
 * -----------------------------------------------------------
 * Modification History
 * Date        Name          Description
 * ------------------------------------------------------------
 * 2016/10/12      c02132         BigData project,new code file.
 * ------------------------------------------------------------
 */
package com.cds.zookeeperlearn.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ListenTest {
    private static String Path = "/cds";
    private static String connect =
            "208.208.102.42:2181,208.208.102.43:2181,208.208.102.44:2181";
    private static CuratorFramework client =
            CuratorFrameworkFactory.builder().connectString(connect)
                    .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

    public static void main(String[] args) throws Exception {
        client.start();
        final NodeCache cache = new NodeCache(client, Path, false);
        cache.start(true);
        cache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("changed");
            }
        });

        final NodeCache cache1 = new NodeCache(client, "/cds1", false);
        cache1.start(true);
        cache1.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("changed1");
            }
        });

        Thread.sleep(Integer.MAX_VALUE);
    }
}
