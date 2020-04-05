package com.atguigu.keyvalueformat;


import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class KVTextMapper extends Mapper<Text, Text, Text, LongWritable>{

    // 1 设置value
    LongWritable v = new LongWritable(1);

    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {

        context.write(key, v);
    }
}


