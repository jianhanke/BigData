package com.atguigu.hdfs;


import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.protocol.LocatedBlock;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.junit.Test;
import sun.security.krb5.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.rmi.ConnectIOException;

public class HDFSClient {


    @Test
    public  void get()throws Exception{
        Configuration configuration=new Configuration();

        FileSystem fileSystem=FileSystem.get(URI.create("hdfs://hadoop102:9000")
                ,configuration,"atguigu");
        fileSystem.copyToLocalFile(new Path("/1.txt"),new Path("D:\\"));
        fileSystem.close();

    System.out.println("over");
    }

    @Test
    public void put() throws IOException, InterruptedException {
        Configuration configuration=new Configuration();
        configuration.set("dfs.replication","2");
        FileSystem fs =FileSystem.get(URI.create("hdfs://hadoop102:9000"),configuration,"atguigu");
        fs.copyFromLocalFile(new Path("D:\\1.txt"),new Path("/3.txt"));
        fs.close();
    }

    @Test
    public void rename()throws Exception{
        Configuration config=new Configuration();
        FileSystem fs= FileSystem.get(URI.create("hdfs://hadoop102:9000"),config,"atguigu");
        fs.rename(new Path("/3.txt"),new Path("/4.txt"));
        fs.close();
    }

    @Test
    public void delete()throws Exception{
        Configuration config=new Configuration();
        FileSystem fs=FileSystem.get(new URI("hdfs://hadoop102:9000"),config,"atguigu");
        fs.delete(new Path("/Test02"),true);
        fs.delete(new Path("/Test"),true);
        fs.delete(new Path("/output2"),true);
        fs.delete(new Path("/output3"),true);
        fs.close();
    }

    @Test
    public void testListFiles() throws Exception{

        // 1获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), configuration, "atguigu");

        // 2 获取文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

        while(listFiles.hasNext()){
            LocatedFileStatus status = listFiles.next();

            // 输出详情
            // 文件名称
            System.out.println(status.getPath().getName());
            // 长度
            System.out.println(status.getLen());
            // 权限
            System.out.println(status.getPermission());
            // 分组
            System.out.println(status.getGroup());

            // 获取存储的块信息
            BlockLocation[] blockLocations = status.getBlockLocations();

            for (BlockLocation blockLocation : blockLocations) {

                // 获取块存储的主机节点
                String[] hosts = blockLocation.getHosts();

                for (String host : hosts) {
                    System.out.println(host);
                }
            }

            System.out.println("-----------班长的分割线----------");
        }

// 3 关闭资源
        fs.close();
    }

    @Test
    public void testList() throws Exception{
        Configuration config=new Configuration();
        FileSystem fs=FileSystem.get(new URI("hdfs://hadoop102:9000"),config,"atguigu");

        RemoteIterator<LocatedFileStatus>   listFile=fs.listFiles(new Path("/"),true);

        while (listFile.hasNext()){
            LocatedFileStatus status=listFile.next();
            System.out.println(status.getPath());
            System.out.println(status.getPath().getName());
            System.out.println(status.getLen());
            System.out.println(status.getPermission());
            System.out.println(status.getGroup());
            BlockLocation[] blockLocations =status.getBlockLocations();
            for( BlockLocation blockLocation:blockLocations){
                String[] hosts=blockLocation.getHosts();
                for(String host:hosts){
                    System.out.println(host);
                }
            }
            System.out.println("---------------------------------");
        }
        fs.close();
    }

    @Test
    public void testListStatus() throws  Exception{
        Configuration config=new Configuration();
        FileSystem fs=FileSystem.get(new URI("hdfs://hadoop102:9000"),config,"atguigu");
        FileStatus[] listStatus=fs.listStatus(new Path("/"));

        for(FileStatus fileStatus:listStatus){
            if(fileStatus.isFile()){
                System.out.println("1文件:"+fileStatus.getPath()+"----"+fileStatus.getPath().getName());
            }else{
                System.out.println("2目录:"+fileStatus.getPath()+"----"+fileStatus.getPath().getName());
            }
        }

    }

    @Test
    public void putFileToHDFS()throws  Exception {
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), config, "atguigu");
        FileInputStream fis = new FileInputStream(new File("d:/1.txt"));
        FSDataOutputStream  fos =fs.create(new Path("/10.txt"));

        IOUtils.copyBytes(fis, fos, config);

        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }
    @Test
    public void getFile()throws Exception{
        Configuration config=new Configuration();
        FileSystem fs=FileSystem.get(new URI("hdfs://hadoop:9000"),config,"atguigu");
        FSDataInputStream fis=fs.open(new Path("/10.txt"));
        FileOutputStream fos=new FileOutputStream(new File("D://9.txt"));

        IOUtils.copyBytes(fis,fos,config);

        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();


    }


}
