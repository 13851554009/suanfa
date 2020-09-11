package com.example.demo.zk;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
public class Watch {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ZooKeeper zooKeeper =
                new ZooKeeper(
                        "172.16.19.164",
                        3000,
                        new Watcher() {
                            public void process(WatchedEvent watchedEvent) {
                                if (Event.KeeperState.SyncConnected.equals(
                                        watchedEvent.getState())) {
                                    countDownLatch.countDown();
                                }
                            }
                        });
        countDownLatch.await();
        final String path = "/zookerperDemo_watcher1";
        zooKeeper.create(
                path, "watcher2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Stat stat =
                zooKeeper.exists(
                        path,
                        new Watcher() { // 通过exists 注册事件机制
                            public void process(WatchedEvent watchedEvent) {
                                System.out.println("exists 事件 " + watchedEvent.getPath());
                                try {
                                    zooKeeper.exists(path, true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }            }
                        });
        System.out.println("开始修改");
        stat = zooKeeper.setData(path, "watcher2_set".getBytes(), stat.getVersion());					// 通过setData 触发鉴定事件
        Thread.sleep(1000);
        System.out.println("修改结束");
    }
}
