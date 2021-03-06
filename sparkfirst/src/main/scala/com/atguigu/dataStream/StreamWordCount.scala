package com.atguigu.dataStream

import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkConf

object StreamWordCount {

  def main(args: Array[String]): Unit = {
      val sparkConf = new SparkConf().setMaster("local[*]").setAppName("countName")
      val ssc = new StreamingContext(sparkConf,Seconds(5))
      val lineStreams = ssc.socketTextStream("hadoop102",9999)
    val wordStream = lineStreams.flatMap(_.split(" "))
    val wordAndOneStream = wordStream.map((_,1))
    val wordAndCountStreams = wordAndOneStream.reduceByKey((x,y)=>(x+y) )

    wordAndCountStreams.print()

    ssc.start()
    ssc.awaitTermination()


  }
}

