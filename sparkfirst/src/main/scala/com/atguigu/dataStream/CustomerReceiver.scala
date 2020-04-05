package com.atguigu.dataStream

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket
import java.nio.charset.StandardCharsets

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.receiver.Receiver

object My {

  def main(args: Array[String]): Unit = {

    //1.初始化Spark配置信息
    val  sparkConf = new SparkConf().setMaster("local[*]").setAppName("StreamWordCount")
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val lineStream = ssc.receiverStream(new CustomerReceiver("hadoop102", 9999))

    val wordStreams = lineStream.flatMap(_.split(" "))

    val wordAndOneStreams = wordStreams.map((_,1))

    val wordAndCountStreams= wordAndOneStreams.reduceByKey(_ + _)

    wordAndCountStreams.print()
    ssc.start()
    ssc.awaitTermination()
  }
}


class CustomerReceiver(host: String, port: Int) extends Receiver[String](StorageLevel.MEMORY_ONLY) {
  override def onStart(): Unit = {
    new Thread("new"){
      override  def run(): Unit ={
          receive()
        }
    }.start()
  }

  def receive(): Unit ={
    val socket = new Socket(host,port)
    var input:String=null
    val reader = new BufferedReader(new InputStreamReader(socket.getInputStream  ,StandardCharsets.UTF_8))
    input=reader.readLine()
    while( input!=null){
        store(input)
        input=reader.readLine()
    }
    socket.close()
    reader.close()
  }


  override def onStop(): Unit = ???
}

