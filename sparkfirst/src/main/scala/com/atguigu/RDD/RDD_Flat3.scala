package com.atguigu.RDD

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_Flat3 {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(2,1,3,4))
    val rdd2=rdd.sortBy(x=>x).collect()
    rdd2.foreach(println)

    val rdd3=rdd.sortBy(x=>x%3  ).collect()
    rdd3.foreach(println)

    val rdd4 = sc.parallelize(1 to 5)
    val rdd5 = sc.parallelize(5 to 10)
    val rdd6 = rdd5.union(rdd4)
    println("******************")
    rdd6.collect().foreach(println)

    val rdd9 = rdd4.subtract(rdd5)
    rdd9.collect().foreach(println)

    println("############")
    val rdd10 = rdd4.intersection(rdd5)
    rdd10.collect().foreach(println)

    rdd4.cartesian(rdd5).collect().foreach(println)



  }
}
