package com.atguigu.test;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class Test {

    public static  void  main(String[] args) throws Exception {
        isTableExist("fdsaf");
    }
    public static Configuration conf;
    static{
        //使用HBaseConfiguration的单例方法实例化
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "192.168.121.102");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
    }
    public static boolean isTableExist(String tableName) throws Exception{
        HBaseAdmin admin = new HBaseAdmin(conf);
        System.out.println(admin.tableExists(tableName));
        return admin.tableExists(tableName);
    }






}
