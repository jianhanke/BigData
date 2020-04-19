package com.atguigu.Sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Test {

  def main(args: Array[String]): Unit = {


    val sparkConf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")

    var spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate();

    spark.sql("show tables").show()


  }
}