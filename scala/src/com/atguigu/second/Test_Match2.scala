package com.atguigu.second

object Test_Match2 {

  def main(args: Array[String]): Unit = {
      val alice = new Person2("Alice", 25)
    val bob = new Person2("Bob", 32)
    val charlie = new Person2("Charlie", 32)
    for(person<-List(alice,bob,charlie)){
      person match {
        case Person2("Alice",25)=>println("Welcome Alice")
        case Person2("Bob",25)=>println("Welcome Alice")
        case Person2(name,age)=>println("anynoe")
      }
    }
  }
  case class Person2(name: String, age: Int)
}

class Person2(name:String,age:Int){
      val name2=name
      val age2=age
}
