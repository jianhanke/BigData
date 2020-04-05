package com.atguigu.nline;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Arrays;

public class NLineReducer extends Reducer<Text, LongWritable,Text,LongWritable> {

    LongWritable v=new LongWritable();
    String[] strs=new String[100];
    int i=0;
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        Long sum=0L;
        for(LongWritable value:values){
            sum+=value.get();
            strs[i]=key.toString();
            i++;
        }
        v.set(sum);
        context.write(key,v);
        System.out.println("((((((((((这是Reduce"+Arrays.toString(strs));
    }

}

