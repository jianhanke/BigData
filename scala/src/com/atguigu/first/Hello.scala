

trait Name{
  def showName(): Unit ={
    println("My name is Lilei");
  }
}
trait  Age extends Name {
  def showAge(): Unit ={
    println("My Age is 18")
  }
}

class Student extends  Age {

}

object Test{
  def main(args: Array[String]): Unit = {
        var stu=new Student;
        stu.showAge()
        stu.showName()
  }
}