package Sql


import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkConf


object RDD {

  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)

    var rdd=sc.makeRDD(List(("hanke",18),("xiaohong",3)));



    val stuRdd = rdd.map {
      line => {
        Student( line._1 ,line._2 );
      }
    }

    stuRdd.collect().foreach(println(_));

  }
    case class Student(name:String,age:Long){}

    def test01: Unit ={



    }

}