package com.atguigu.second

object Test_Match {

  def main(args: Array[String]): Unit = {
      println(matchTest(3))
  }

  def matchTest(x:Int):String=x match{
      case 1=>"one"
      case 2=>"two"
      case 3=>"three"

  }
}
