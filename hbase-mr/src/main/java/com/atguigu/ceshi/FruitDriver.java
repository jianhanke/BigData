package com.atguigu.ceshi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class FruitDriver extends Configuration implements Tool{

    private Configuration configuration = null;

    public static void main(String[] args) throws Exception {

        Configuration configuration = HBaseConfiguration.create();
        int i = ToolRunner.run(configuration, new FruitDriver(), args);
    }
    public int run(String[] strings) throws Exception {
        //获取任务对象
        Job job = Job.getInstance(configuration);
        //指定Driver类
        job.setJarByClass(FruitDriver.class);
        //指定Mapper
        TableMapReduceUtil.initTableMapperJob("fruit",new Scan(),FruitMapper.class, ImmutableBytesWritable.class,Put.class,job);
        //指定Reducer
        TableMapReduceUtil.initTableReducerJob("fruit_mr", FruitReducer.class, job);
        //提交
        boolean b = job.waitForCompletion(true);

        return b?0:1;
    }

    public void setConf(Configuration conf) {
        this.configuration = conf;
    }

    public Configuration getConf() {
        return configuration;
    }



}