package com.atguigu.dataStream

import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

object KafkaSparkStreaming {

  def main(args: Array[String]): Unit = {

    //1.创建SparkConf并初始化SSC
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("KafkaSparkStreaming")
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    //4.通过KafkaUtil创建kafkaDSteam
    val kafkaDSteam: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream(
        ssc,
      "hadoop102:2181",
      "atguigu",
      Map("atguigu"->3)
    )

    val wordDStream:DStream[String]  = kafkaDSteam.flatMap(t=>t._2.split("") )
    val mapDStream: DStream[(String,Int)] = wordDStream.map((_,1))
    val wordToSumDStream = mapDStream.reduceByKey(_+_)
    wordToSumDStream.print()
    ssc.start()
    ssc.awaitTermination()


    //6.启动SparkStreaming
    ssc.start()
    ssc.awaitTermination()
  }
}

