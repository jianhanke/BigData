package com.atguigu.Action

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object SeriTest {

  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val rdd: RDD[String] = sc.parallelize(Array("hadoop", "spark", "hive", "atguigu"))
    val search = new Search("h")
    val match1: RDD[String] = search.getMatche2(rdd)
    match1.collect().foreach(println)
  }
}
//class Search(query:String) extends java.io.Serializable{
  class Search(query:String){
  def isMatch(s: String): Boolean = {
    s.contains(query)
  }
  def getMatch1 (rdd: RDD[String]): RDD[String] = {
    rdd.filter(isMatch)
  }
  def getMatche2(rdd: RDD[String]): RDD[String] = {
    var q=query
    rdd.filter(x => x.contains(q))
  }

}

