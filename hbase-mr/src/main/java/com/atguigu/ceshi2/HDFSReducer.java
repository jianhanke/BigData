package com.atguigu.ceshi2;


import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class HDFSReducer extends TableReducer<NullWritable, Put,NullWritable>{

    @Override
    protected void reduce(NullWritable key, Iterable<Put> values, Context context) throws IOException, InterruptedException {

        //遍历写出
        for (Put value : values) {
            context.write(NullWritable.get(), value);
        }

    }
}
