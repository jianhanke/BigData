package com.atguigu.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Flat4 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val rdd1 = sc.parallelize(Array(1,2,3),3)
    val rdd2 = sc.parallelize(Array("a","b","c"),3)
    rdd2.zip(rdd1).collect().foreach(println)

    val rdd = sc.parallelize(Array((1,"aaa"),(2,"bbb"),(3,"ccc"),(4,"ddd")),4)

    println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^")
    rdd.foreach( array=> array.toString() )
    println(rdd.partitions.size)

    var rdd5 =rdd.partitionBy(new org.apache.spark.HashPartitioner(2))
    println(rdd5.partitions.size)



  }
}
