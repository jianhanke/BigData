package com.atguigu.RDD

import org.apache.spark.{SparkConf, SparkContext}

object RDD6 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)),2)
    val agg = rdd.aggregateByKey(0)(math.max(_,_),_+_ )
    agg.collect().foreach(println)

    val rdd3 = sc.parallelize(List((1,3),(1,2),(1,4),(2,3),(3,6),(3,8)),1)
    rdd3.foldByKey(0)(_+_).collect().foreach(println)

    val rdd4 = sc.parallelize(List((1,"a"),(1,"d"),(2,"b"),(3,"c")))
    rdd4.mapValues(_+"|||").collect().foreach(println)

    val rdd5 = sc.parallelize(Array((1,"a"),(2,"b"),(3,"c"),(5,9)))
    val rdd6 = sc.parallelize(Array((1,4),(2,5),(4,6),(5,3),(5,2)))
    rdd5.join(rdd6).collect().foreach(println)

    val rdd7 = sc.parallelize(Array((1,"a"),(2,"b"),(3,"c")))
    val rdd1 = sc.parallelize(Array((1,4),(2,5),(3,6)))

  }
}
