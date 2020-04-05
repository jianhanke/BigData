package com.atguigu.RDD

import org.apache.spark.{SparkConf, SparkContext}

object RDD_Flat5 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val words = Array("one", "two", "two", "three", "three", "three")
    val wordPairsRDD = sc.parallelize(words).map(word => (word, 1))

    wordPairsRDD.foreach(println)

    val group = wordPairsRDD.groupByKey()
    group.foreach(println)

    group.map(t=>(t._1,t._2.sum)).collect().foreach(println)

    val rdd = sc.parallelize(List(("female",1),("male",5),("female",5),("male",2)))
    val reduce = rdd.reduceByKey((x,y)=>x+y)
    reduce.foreach(println)



  }
}
