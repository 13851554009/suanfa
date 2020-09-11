package com.example.demo.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class connection {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            ZooKeeper zooKeeper =
                    new ZooKeeper(
                            "172.16.19.164",
                            3000,
                            new Watcher() {
                                public void process(WatchedEvent watchedEvent) {
                                    if (Event.KeeperState.SyncConnected.equals(
                                            watchedEvent.getState())) { // 收到服务端响应,连接成功
                                        countDownLatch.countDown();
                                    }
                                }
                            });
            countDownLatch.await();
            System.out.println(zooKeeper.getState()); // CONNECTING
            String s =
                    zooKeeper.create(
                            "/zk-persismic",
                            "xjj".getBytes(),
                            ZooDefs.Ids.OPEN_ACL_UNSAFE,
                            CreateMode.PERSISTENT); // 创建
            System.out.println(s);
            Stat stat = new Stat();
            byte[] bytes = zooKeeper.getData("/zk-persismic", null, stat);
            // 得到当前节点的值
            System.out.println(new String(bytes));
            zooKeeper.setData("/zk-persis mic", "1".getBytes(), stat.getVersion()); 						// 修改节点值
            byte[] bytes1 = zooKeeper.getData("/zk-persis mic", null, stat);
            // 得到当前节点的值
            System.out.println(new String(bytes1));
            zooKeeper.delete("/zk-persis mic", stat.getVersion());
            zooKeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
