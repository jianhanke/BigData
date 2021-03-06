package com.atguigu.flowsum;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text,Text, FlowBean> {

    private Text phone=new Text();
    private FlowBean flow=new FlowBean();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields=value.toString().split("\t");
        phone.set(fields[1]);
        Long upFlow=Long.parseLong(fields[fields.length-3]);
        Long downFlow=Long.parseLong(fields[fields.length-2]);
        flow.set(upFlow,downFlow);
        context.write(phone,flow);

    }
}
