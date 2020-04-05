package com.atguigu.RDD

import org.apache.spark.{SparkConf, SparkContext}

object RDD_Flat {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)
    val sourceFlat = sc.parallelize(1 to 5)
    sourceFlat.collect().foreach(println)
    val flatMap = sourceFlat.flatMap(1 to _)
    flatMap.collect().foreach(println)

    val rdd = sc.parallelize(1 to 16,4)
    rdd.collect().foreach(println)
    val rdd2=rdd.glom().collect()
    rdd2.foreach(println)

  }
}
