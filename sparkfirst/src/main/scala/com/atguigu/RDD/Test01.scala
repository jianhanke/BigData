package com.atguigu.RDD

import org.apache.spark.{SparkConf, SparkContext}

object Test01{

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val myMakeRdd = sc.makeRDD(1 to 10)
    myMakeRdd.collect().foreach(println)

    var rdd2=sc.parallelize(Array(1,2,3,4,5));
    rdd2.collect().foreach(println)
    var rdd3=sc.parallelize(List(1,2,3,4));
    rdd3.collect().foreach(println)
    var rdd4=sc.textFile("in")
    rdd4.collect().foreach(println)
    println(myMakeRdd.collect())

    println("---------Map")

    val source = sc.parallelize(1 to 10)
    val source2=source.map(_*2);
    source2.collect().foreach(println)

    val source3 = source.map(x=>x*3)
    source3.collect().foreach(println)

    val mySource = sc.parallelize(Array(2,4,5,6))
    val mySource2=mySource.mapPartitions(x=>x.map(_*3));
    mySource2.collect().foreach(println)

    val my1 = sc.textFile("in")
    val my2 = my1.mapPartitions(x=>x)
    my2.collect().foreach(println)

    val my3 = sc.textFile("in")
     val my4 = my1.mapPartitions(x=>x.map("jiahanke "+_))
    my4.collect().foreach(println)

    val rdd = sc.parallelize(Array(1,2,3,4))
    val rdd5 = rdd.mapPartitionsWithIndex((index,partitions)=>(partitions.map( (index,_) )))
    rdd5.collect().foreach(println)

  }

}
