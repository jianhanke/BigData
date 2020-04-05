package com.atguigu.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZkClient {

    private ZooKeeper zkCli;
    private static final String CONNECT_STRING="hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private static final int SESSION_TIMEOUT=2000;

    @Before
    public void before() throws IOException {
        zkCli=new ZooKeeper(CONNECT_STRING,SESSION_TIMEOUT, new Watcher() {
            public void process(WatchedEvent e) {
                System.out.println("默认回调函数");
            }
        });
    }
    @Test
    public void ls() throws KeeperException, InterruptedException {
        List<String> children=zkCli.getChildren("/test09",true);
        System.out.println("========================");
        for(String str:children){
            System.out.println(str);
        }
        System.out.println("========================");
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String str=zkCli.create("/Idea","this is a idea".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(str);
    }

    @Test //稍有疑问
    public void get() throws KeeperException, InterruptedException {
        byte[] data=zkCli.getData("/Idea",true,new Stat());
        String string=new String(data);
        System.out.println(string);
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void stat() throws KeeperException, InterruptedException {
        Stat exists=zkCli.exists("/Idea",true);
        if(exists==null){
            System.out.println("不存在");
        }else{
            System.out.println(exists.getDataLength());
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void delete() throws KeeperException, InterruptedException {
        Stat exists=zkCli.exists("/Idea",false);
        if(exists!=null){
            zkCli.delete("/Idea",exists.getVersion());
        }
    }
    @Test
    public void register() throws KeeperException, InterruptedException {
        byte[] data = zkCli.getData("/a", new Watcher() {

            public void process(WatchedEvent event) {
                try {
                    register();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, null);
        System.out.println(new String(data));
    }

    @Test
    public void testRegister() {
        try {
            register();
            Thread.sleep(Long.MAX_VALUE);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
