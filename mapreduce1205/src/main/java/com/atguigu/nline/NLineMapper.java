package com.atguigu.nline;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;
import java.util.Arrays;

public class NLineMapper extends Mapper<LongWritable, Text,Text,LongWritable> {
    Text k=new Text();
    LongWritable v=new LongWritable(1);
    String[] strs=new String[100];
    int i=0;
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String string=value.toString();
        String[] splited=string.split(" ");
        for(String str:splited){
            strs[i]=str;
            i++;
            k.set(str);
            context.write(k,v);
        }
        System.out.println("----------Mapper"+ Arrays.toString(strs));
    }
}


