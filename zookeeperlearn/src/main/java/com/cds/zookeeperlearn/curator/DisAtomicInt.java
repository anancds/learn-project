package com.cds.zookeeperlearn.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

public class DisAtomicInt {
    private static String Path = "/cds";
    private static String connect =
        "208.208.102.212:2181,208.208.102.213:2181,208.208.102.214:2181";
    private static CuratorFramework client =
        CuratorFrameworkFactory.builder().connectString(connect)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

    public static void main(String[] args) throws Exception {
        client.start();
        DistributedAtomicInteger atomicInteger =
            new DistributedAtomicInteger(client, Path, new RetryNTimes(3, 1000));
        AtomicValue<Integer> rc = atomicInteger.add(8);
        System.out.println("Result: " + rc.succeeded());
    }
}
