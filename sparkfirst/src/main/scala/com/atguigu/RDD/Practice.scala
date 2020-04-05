package com.atguigu.RDD

import org.apache.spark.{SparkConf, SparkContext}

object  Practice {

  def main(args: Array[String]): Unit = {

    val conf=new SparkConf().setMaster("local[*]").setAppName("practice")
    val sc=new SparkContext(conf)
    val line=sc.textFile("d://agent.log")
    line.collect().foreach(println)
    val provinceAdToOne = line.map { x =>
      val fields: Array[String] = x.split(" ")
      ( ((fields(1),fields(4)),1))
    }
    val partitons = provinceAdToOne.reduceByKey( (x,y)=>x+y )
    partitons.collect().foreach(println)

    val province=partitons.map{ x=> (x._1._1,x._2 ) }
    province.collect().foreach(println)

    val provinceGroup = province.groupByKey()
    provinceGroup.collect().foreach(println)

    val three = provinceGroup.mapValues (
      x => x.toList.sortWith((x, y) => x > y).take(3)
    )
    three.collect().foreach(println)

    sc.stop()
  }



}
