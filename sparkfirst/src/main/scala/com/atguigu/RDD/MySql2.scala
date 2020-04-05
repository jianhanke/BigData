package com.atguigu.RDD

import org.apache.spark.{SparkConf, SparkContext}

object MySql2 {

  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("JdbcRDD")
    val sc = new SparkContext(sparkConf)

    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://hadoop102:3306/rdd"
    val userName = "root"
    val passWd = "123456"

    val dataRDD = sc.makeRDD(List(("jianhanke",20),("haha",30)))

    dataRDD.foreachPartition(datas=>{
      Class.forName(driver)
      val connection = java.sql.DriverManager.getConnection(url,userName,passWd)
      datas.foreach{
        case(username,age)=>{
          val sql = "insert into user(name,age) values(?,?)"
          val statement = connection.prepareStatement(sql)
          statement.setString(1,username)
          statement.setInt(2,age)
          statement.executeUpdate()
          statement.close()
        }
      }
    }  )




  }

}
