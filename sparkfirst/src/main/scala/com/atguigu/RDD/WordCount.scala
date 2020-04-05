package com.atguigu.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount{

  def main(args: Array[String]): Unit = {


    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val lines=sc.textFile("in")
    val words:RDD[String]=lines.flatMap(_.split(" "))
    val wordToOne=words.map((_,1));
    val wordTosum:RDD[(String,Int)]=wordToOne.reduceByKey(_+_)
    val result:Array[(String,Int)] =wordTosum.collect()
    result.foreach(println)

    sc.stop()
  }
}
