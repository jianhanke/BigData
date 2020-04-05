package com.atguigu.outputformat;



import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;


public class FRecordWriter extends RecordWriter<Text, NullWritable> {

	FSDataOutputStream fosatiguigu;
	FSDataOutputStream  fosother;
	public FRecordWriter(TaskAttemptContext job) throws IOException {
		FileSystem fs=FileSystem.get(job.getConfiguration());
		fosatiguigu=fs.create(new Path("D://Ac/atguigu.log"));
		fosother=fs.create(new Path("D://Ac/other.log"));
	}

	@Override
	public void write(Text key, NullWritable value) throws IOException, InterruptedException {
		if(key.toString().contains("atguigu")){
			fosatiguigu.write(key.toString().getBytes());
		}else{
			fosother.write(key.toString().getBytes());
		}
	}

	@Override
	public void close(TaskAttemptContext context) throws IOException, InterruptedException {
		IOUtils.closeStream(fosatiguigu);
		IOUtils.closeStream(fosother);
	}
}
