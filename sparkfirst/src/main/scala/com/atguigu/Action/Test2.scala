package com.atguigu.Action

import org.apache.spark.{SparkConf, SparkContext}

object Test2 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    var rdd=sc.makeRDD(List(1,2,3,4))
    println(rdd.getClass)
    rdd.foreach{
      case i=>{
          println(i*2)
      }
    }
    val val2 = rdd.collect
    println(val2.getClass)
    val2.foreach{
      case i=>{
        println(i*2)
      }
    }


  }

}
