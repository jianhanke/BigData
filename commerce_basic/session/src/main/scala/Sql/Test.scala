package Sql

import java.io.File

import scala.collection.mutable.Map
import commons.utils.DateUtils
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.json4s.jackson.Json

import scala.collection.mutable

object Test {

  def main(args: Array[String]): Unit = {

//
//    val sparkConf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
//    val warehouseLocation: String = new File("spark-warehouse").getAbsolutePath
//
//    var spark: SparkSession = SparkSession
//      .builder()
//      .config(sparkConf)
//      .config("spark.sql.warehouse.dir",warehouseLocation)
//      .enableHiveSupport()
//      .getOrCreate();

    var info= ( if(10>1) "1答案是:"+  "第一个对" +"|" else "第二个对" )+
              (if(10<2) "2答案是:"+ "第二个对"+        "|" else "第二个错" )

    println(info)

    var map  = mutable.HashMap[String,Int] ();
    map += ("test01"->1);
    map += ("test02"->2);

    var map2  = mutable.HashMap[String,Int] ();
    map2 += ("test02"->5);
    map2 += ("test03"->3);

    map2.update("test02",map2("test02")+1 )

    println(map2);


  }



}