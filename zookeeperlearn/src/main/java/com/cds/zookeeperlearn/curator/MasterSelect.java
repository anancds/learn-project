package com.cds.zookeeperlearn.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class MasterSelect {
    private static String Path = "/cds";
    private static String connect =
        "208.208.102.212:2181,208.208.102.213:2181,208.208.102.214:2181";
    private static CuratorFramework client =
        CuratorFrameworkFactory.builder().connectString(connect)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

    public static void main(String[] args) throws Exception {

        client.start();
        LeaderSelector selector =
            new LeaderSelector(client, Path, new LeaderSelectorListenerAdapter() {
                @Override public void takeLeadership(CuratorFramework client) throws Exception {
                    System.out.println("i am the master!");
                    Thread.sleep(3000);
                    System.out.println("finish master, release master!");
                }

            });

        selector.autoRequeue();
        selector.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
