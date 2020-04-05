package com.atguigu.Action

import org.apache.spark.{SparkConf, SparkContext}

object Test {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)
    val rdd1 = sc.makeRDD(1 to 10,2)
    rdd1.reduce(_+_)
//    rdd1.collect().foreach(println)

    val rdd2 = sc.makeRDD(Array(("a",1),("a",3),("c",3),("d",5)))
    val rdd3 = rdd2.reduce((x,y)=>(x._1 + y._1,x._2 + y._2))
    println(rdd3)

    val rdd = sc.parallelize(1 to 10)
    println(rdd.count)
    println(rdd.first())
    rdd.take(3).foreach(println)

    val rdd5 = sc.parallelize(Array(2,5,4,6,8,3))
    rdd5.takeOrdered(3).foreach(println)

    var rdd10 = sc.makeRDD(1 to 10,2)
    val count = rdd10.fold(0)(_+_).toString

    println(count)

    val rdd11 = sc.parallelize(List((1,3),(1,2),(1,4),(2,3),(3,6),(3,8)),3)

    println(rdd11.countByKey.toString())


  }

}
